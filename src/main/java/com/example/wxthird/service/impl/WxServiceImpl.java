package com.example.wxthird.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.wxthird.config.WxThirdConfig;
import com.example.wxthird.service.WxService;
import com.example.wxthird.utils.RedisKey;
import com.example.wxthird.utils.RedisUtils;
import com.example.wxthird.utils.WxMsgCryptionUtils;
import com.example.wxthird.utils.XmlUtil;
import com.example.wxthird.wxapi.WxApi;
import com.example.wxthird.wxapi.model.*;
import com.qq.weixin.mp.aes.AesException;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 侯存路
 * @date 2018/11/29
 * @company codingApi
 * @description
 */
@Service
public class WxServiceImpl implements WxService {


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Autowired
    private WxThirdConfig wxThirdConfig;


    Logger logger = LoggerFactory.getLogger(WxServiceImpl.class);



    @Override
    public void getTicket(String timestamp, String nonce, String msgSignature, String postData) {
        String  res = null;
        try {
            res = WxMsgCryptionUtils.decryptCode(msgSignature ,timestamp , nonce , postData );
        } catch (AesException e) {
            e.printStackTrace();
        }
        Map<String,Object> map = XmlUtil.xml2mapWithAttr(res , false);
        String type = map.get("InfoType").toString();
        switch (type){
            case "component_verify_ticket":
                // 存储 ticket
                logger.info(" ticket 存储成功 >>> {}" , map);
                redisTemplate.opsForValue().set(RedisKey.ticket, map.get("ComponentVerifyTicket").toString());
              break;
            case "authorized":
                logger.info(" 授权成功通知 >>> " , map);
             break;
            case "unauthorized":
                logger.info(" 取消授权通知 >>> " , map);
                break;
            case "updateauthorized":
                logger.info(" 授权更新通知 >>> " , map);
                break;
            case "notify_third_fasteregister":
                logger.info(" 注册审核事件推送 >>> " , map);
                registerEventPush(map);
                break;
            default:
                break;
        }
    }



    private  void registerEventPush(Map<String,Object> map){
        RegisterEventPush registerEventPush = new RegisterEventPush(map);
        logger.info(" 注册审核事件推送 >>> " , registerEventPush);
    }




    @Override
    public String getPreAuthCode() {
        String   preAuthCode ="";

        preAuthCode  =   RedisUtils.getValueForKeyAndExpire(RedisKey.preAuthCode);
        if(!StringUtils.isEmpty(preAuthCode)){
            logger.info(" 获取存储的 preAuthCode --->" + preAuthCode);
            return  preAuthCode;
        }

        String componentAccessToken = getComponentAccessToken();
        logger.info("componentAccessToken = " + componentAccessToken);

        ResPreAuthCode resPreAuthCode =  WxApi.apiCreatePreAuthCode(componentAccessToken , new ReqPreAuthCode(wxThirdConfig.getAppid()) );
        preAuthCode =  resPreAuthCode.getPre_auth_code();

        return  preAuthCode;
    }





    @Override
    public String getComponentAccessToken() {
        String  componentAccessToken = "";
        componentAccessToken =  RedisUtils.getValueForKeyAndExpire(RedisKey.componentAccessToken);
        if(!StringUtils.isEmpty(componentAccessToken)){
            logger.info(" 获取存储的 ComponentAccessToken --->" + componentAccessToken);
            return  componentAccessToken;
        }

        /**
         * 重新获取  componentAccessToken
         */
        String ticket =   redisTemplate.opsForValue().get(RedisKey.ticket).toString();
        if(StringUtils.isEmpty(ticket)){
            throw new NullPointerException("获取 ticket 为空");
        }

        ResComponentToken resComponentToken =  WxApi.apiComponentToken(new ReqComponentToken(wxThirdConfig.getAppid() , wxThirdConfig.getAppsecret() ,  ticket));
        componentAccessToken = resComponentToken.getComponent_access_token();
        return componentAccessToken;
    }


    @Override
    public String queryAuth(String authorizationCode) {
        ResApiQueryAuth resApiQueryAuth =   WxApi.apiQueryAuth(getComponentAccessToken() , new ReqApiQueryAuth(wxThirdConfig.getAppid() , authorizationCode) );
        return JSON.toJSONString(resApiQueryAuth);
    }


    @Override
    public String getScanCodeAuthorization() {
        String redirect_uri = "http://test.codingapi.com/wx/start.html?userId=1";
        String url = String.format(WxApi.SCANCODEAUTHORIZATION , wxThirdConfig.getAppid() ,getPreAuthCode() ,  redirect_uri );
        return url;
    }


    @Override
    public String getQuickAuthorization() {
        String redirect_uri = "http://test.codingapi.com/wx/start.html?userId=1";
        String url = String.format(WxApi.BINDCOMPONENT , wxThirdConfig.getAppid() ,getPreAuthCode() ,  redirect_uri );
        return url;
    }



    @Override
    public ResApiAuthorizerToken getApiAuthorizerToken(String authorizerRefreshToken, String authorizerAppId) {
        ResApiAuthorizerToken resApiAuthorizerToken =  WxApi.apiAuthorizerToken( getComponentAccessToken() , new ReqApiAuthorizerToken(wxThirdConfig.getAppid() , authorizerAppId , authorizerRefreshToken ));
        return resApiAuthorizerToken;
    }



    @Override
    public ResApiGetAuthorizerInfoPubic getAuthorizerInfo(String authorizerAppid) {
        ResApiGetAuthorizerInfoPubic resApiGetAuthorizerInfoPubic =   WxApi.apiGetAuthorizerInfoPubic( getComponentAccessToken() , new ReqApiGetAuthorizerInfoPubic(wxThirdConfig.getAppid() , authorizerAppid ) );
        return resApiGetAuthorizerInfoPubic;
    }


}
