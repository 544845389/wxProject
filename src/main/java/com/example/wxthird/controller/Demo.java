package com.example.wxthird.controller;

import com.alibaba.fastjson.JSON;
import com.example.wxthird.service.WxService;
import com.example.wxthird.utils.RedisKey;
import com.example.wxthird.wxapi.WxApi;
import com.example.wxthird.wxapi.model.ReqApiQueryAuth;
import com.example.wxthird.wxapi.model.ResApiAuthorizerToken;
import com.example.wxthird.wxapi.model.ResApiGetAuthorizerInfoPubic;
import com.example.wxthird.wxapi.model.ResApiQueryAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 侯存路
 * @date 2018/11/28
 * @company codingApi
 * @description
 */
@Controller
@RequestMapping("/wx")
public class Demo {


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private WxService wxService;


    /**
     * 获取 获取预授权码
     * @return
     */
    @ResponseBody
    @RequestMapping("/getPreAuthCode")
    public  String getPreAuthCode(){
      return     wxService.getPreAuthCode();
    }



    /**
     * 使用授权码换取公众号或小程序的接口调用凭据和授权信息
     * @return
     */
    @ResponseBody
    @GetMapping("/getApiQueryAuth")
    public  String api_query_auth(@RequestParam("authorizationCode") String authorizationCode){

        return wxService.queryAuth(authorizationCode);
    }



    /**
     * 获取（刷新）授权公众号或小程序的接口调用凭据（令牌）
     * @return
     */
    @ResponseBody
    @GetMapping("/getApiAuthorizerToken")
    public ResApiAuthorizerToken api_authorizer_token(
            @RequestParam("authorizer_refresh_token") String authorizerRefreshToken ,
            @RequestParam("authorizer_appid") String authorizerAppId ){
        return  wxService.getApiAuthorizerToken(authorizerRefreshToken , authorizerAppId);
    }



    /**
     * 方式一：授权注册页面扫码授权
     * @return
     */
    @ResponseBody
    @GetMapping("/getScanCodeAuthorization")
    public  String getOneUrl(){
        return wxService.getScanCodeAuthorization();
    }




    /**
     * 方式二：点击移动端链接快速授权
     * @return
     */
    @ResponseBody
    @GetMapping("/getQuickAuthorization")
    public  String getTwoUrl(){
        return wxService.getQuickAuthorization();
    }


    /**
     * 获取授权方的帐号基本信息  (1)公众号获取
     * @return
     */
    @ResponseBody
    @GetMapping("/getAuthorizerInfo")
    public ResApiGetAuthorizerInfoPubic getAuthorizerInfo(@RequestParam("authorizer_appid") String authorizer_appid){
        return wxService.getAuthorizerInfo(authorizer_appid);
    }





    @ResponseBody
    @GetMapping("/clear")
    public  String clear(){
        redisTemplate.opsForValue().set(RedisKey.componentAccessToken , "");
        redisTemplate.opsForValue().set(RedisKey.preAuthCode , "");
        return     "";
    }





}
