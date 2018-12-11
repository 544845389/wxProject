package com.example.wxthird.service.impl;

import com.example.wxthird.config.WxThirdConfig;
import com.example.wxthird.service.WxService;
import com.example.wxthird.utils.RedisKey;
import com.example.wxthird.utils.RedisUtils;
import com.example.wxthird.utils.WxMsgCryptionUtils;
import com.example.wxthird.utils.XmlUtil;
import com.example.wxthird.wxapi.WxApi;
import com.example.wxthird.wxapi.model.*;
import com.qq.weixin.mp.aes.AesException;
import org.apache.commons.lang.StringUtils;
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
        Map<String,String> map = XmlUtil.xml2mapWithAttr(res , false);
        logger.info(" ticket 存储成功 >>> {}" , map);
        redisTemplate.opsForValue().set(RedisKey.ticket, map.get("ComponentVerifyTicket"));
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
    public String getScanCodeAuthorization() {
        String redirect_uri = "http://test.codingapi.com/wx/start.html";
        String url = String.format(WxApi.SCANCODEAUTHORIZATION , wxThirdConfig.getAppid() ,getPreAuthCode() ,  redirect_uri );
        return url;
    }


}
