package com.example.wxthird.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.wxthird.config.WxThirdConfig;
import com.example.wxthird.model.WxUrl;
import com.example.wxthird.service.WxService;
import com.example.wxthird.utils.WxMsgCryptionUtils;
import com.example.wxthird.utils.XmlUtil;
import com.lorne.core.framework.utils.http.HttpUtils;
import com.qq.weixin.mp.aes.AesException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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


    @Override
    public void getTicket(String timestamp, String nonce, String msgSignature, String postData) {
        String  res = null;
        try {
            res = WxMsgCryptionUtils.decryptCode(msgSignature ,timestamp , nonce , postData );
        } catch (AesException e) {
            e.printStackTrace();
        }
        Map<String,String> map = XmlUtil.xml2mapWithAttr(res , false);
        redisTemplate.opsForValue().set("ticket" , map.get("ComponentVerifyTicket"));
        System.out.println("ticket 存储成功 >>>" + JSON.toJSONString(map));
    }



    @Override
    public String getPreAuthCode() {
        String component_access_token = getComponentAccessToken();
        System.out.println("component_access_token = " + component_access_token);

        Map<String,String> map = new HashMap<>();
        map.put("component_appid", wxThirdConfig.getAppid());

        String url = WxUrl.API_CREATE_PREAUTHCODE+component_access_token;
        String json  =  HttpUtils.postJson(url , JSON.toJSONString(map));
        System.out.println("json = " + json);
        JSONObject jsonObject =  JSON.parseObject(json);
        String   pre_auth_code  =  jsonObject.getString("pre_auth_code");
        return  pre_auth_code;
    }





    @Override
    public String getComponentAccessToken() {
        String  componentAccessToken = "";
        componentAccessToken =  redisTemplate.opsForValue().get("componentAccessToken").toString();
        int  surplus =  redisTemplate.getExpire("componentAccessToken" ,TimeUnit.SECONDS ).intValue();
        if(!StringUtils.isEmpty(componentAccessToken)){
            if(surplus > 600) {
                    return  componentAccessToken;
            }
        }

        /**
         * 重新获取  componentAccessToken
         */
        String ticket =   redisTemplate.opsForValue().get("ticket").toString();
        if(StringUtils.isEmpty(ticket)){
            throw new NullPointerException("获取 ticket 为空");
        }

        Map<String,String> map = new HashMap<>();
        map.put("component_appid", wxThirdConfig.getAppid());
        map.put("component_appsecret", wxThirdConfig.getAppsecret());
        map.put("component_verify_ticket", ticket);

        String url = WxUrl.API_COMPONENT_TOKEN;
        String json  =  HttpUtils.postJson(url , JSON.toJSONString(map));
        JSONObject  jsonObject = JSON.parseObject(json);
        redisTemplate.opsForValue().set("componentAccessToken" , jsonObject.get("component_access_token") , jsonObject.getLong("expires_in") , TimeUnit.SECONDS);
        return componentAccessToken;
    }


}
