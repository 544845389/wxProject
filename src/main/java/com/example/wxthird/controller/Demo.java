package com.example.wxthird.controller;

import com.alibaba.fastjson.JSON;
import com.example.wxthird.service.WxService;
import com.example.wxthird.utils.RedisKey;
import com.example.wxthird.wxapi.WxApi;
import com.example.wxthird.wxapi.model.ReqApiQueryAuth;
import com.example.wxthird.wxapi.model.ResApiQueryAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
     * 授权注册页面扫码授权
     * @return
     */
    @ResponseBody
    @RequestMapping("/componentLoginPage")
    public  void componentLoginPage(){

//        https://mp.weixin.qq.com/cgi-bin/componentloginpage?component_appid=wx22bf3c141c8d8470&pre_auth_code=preauthcode@@@4RGRONo4zvAkekzPn6-3bUJMM63D2o_ZADG3hcyv3Bxif6D8FDnM-DPoltgFBQ3b&redirect_uri=http://test.codingapi.com/wx

    }


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
    public  String api_query_auth(){
        String code = wxService.getPreAuthCode();
        String accessToken = wxService.getComponentAccessToken();
        ResApiQueryAuth resApiQueryAuth =   WxApi.apiQueryAuth(accessToken , new ReqApiQueryAuth("wx22bf3c141c8d8470" ,code ));
        System.out.println("resApiQueryAuth = " + JSON.toJSONString(resApiQueryAuth));
        return     "";
    }




    /**
     *  html
     * @return
     */
    @GetMapping("/getHtml")
    public  String getHtml(){
        return "index";
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







    @ResponseBody
    @GetMapping("/clear")
    public  String clear(){
        redisTemplate.opsForValue().set(RedisKey.componentAccessToken , "");
        redisTemplate.opsForValue().set(RedisKey.preAuthCode , "");
        return     "";
    }





}
