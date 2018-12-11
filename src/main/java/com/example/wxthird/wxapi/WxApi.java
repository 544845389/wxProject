package com.example.wxthird.wxapi;

import com.alibaba.fastjson.JSON;
import com.example.wxthird.utils.RedisKey;
import com.example.wxthird.utils.RedisUtils;
import com.example.wxthird.wxapi.model.ReqComponentToken;
import com.example.wxthird.wxapi.model.ReqPreAuthCode;
import com.example.wxthird.wxapi.model.ResComponentToken;
import com.example.wxthird.wxapi.model.ResPreAuthCode;
import com.lorne.core.framework.utils.http.HttpUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author 侯存路
 * @date 2018/12/11
 * @company codingApi
 * @description
 */
@Component
public class WxApi {



    private static WxApi wxApi;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostConstruct
    public void init() {
        wxApi = this;
        wxApi.redisTemplate = this.redisTemplate;
    }









    /**
     * 获取预授权码  pre_auth_code
     */
    public   static  String API_CREATE_PREAUTHCODE = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=";


    /**
     * 获取第三方平台component_access_token
     */
    public   static  String API_COMPONENT_TOKEN = "https://api.weixin.qq.com/cgi-bin/component/api_component_token";





    /**
     *   获取预授权码  pre_auth_code
     * @return
     */
    public  static ResPreAuthCode apiCreatePreAuthCode(String componentAccessToken , ReqPreAuthCode reqPreAuthCode){
        String url =  API_CREATE_PREAUTHCODE+componentAccessToken;
        String json  =  HttpUtils.postJson(url , JSON.toJSONString(reqPreAuthCode));
        System.out.println(" WxApi -- > apiCreatePreAuthCode --> "+json);
        ResPreAuthCode  resPreAuthCode =  JSON.parseObject(json ,ResPreAuthCode.class);
        if(StringUtils.isEmpty(resPreAuthCode.getPre_auth_code())){
           throw  new NullPointerException("pre_auth_code 获取失败！"+json);
        }
        wxApi.redisTemplate.opsForValue().set(RedisKey.preAuthCode , resPreAuthCode.getPre_auth_code()  , resPreAuthCode.getExpires_in() , TimeUnit.SECONDS);
        return  resPreAuthCode;
    }




    /**
     *   获取第三方平台component_access_token
     * @return
     */
    public  static ResComponentToken apiComponentToken( ReqComponentToken reqPreAuthCode){
        String url =  API_COMPONENT_TOKEN;
        String json  =  HttpUtils.postJson(url , JSON.toJSONString(reqPreAuthCode));
        System.out.println(" WxApi -- > apiComponentToken --> "+json);
        ResComponentToken  resComponentToken =  JSON.parseObject(json ,ResComponentToken.class);
        if(StringUtils.isEmpty(resComponentToken.getComponent_access_token())){
            throw  new NullPointerException("component_access_token 获取失败！"+json);
        }
        wxApi.redisTemplate.opsForValue().set(RedisKey.preAuthCode , resComponentToken.getComponent_access_token()  , resComponentToken.getExpires_in() , TimeUnit.SECONDS);
        return  resComponentToken;
    }





}
