package com.example.wxthird.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.wxthird.config.WxThirdConfig;
import com.example.wxthird.model.WxUrl;
import com.example.wxthird.service.WxService;
import com.lorne.core.framework.utils.http.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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
//        String url = "https://mp.weixin.qq.com/cgi-bin/componentloginpage?component_appid="+appid+"&pre_auth_code="++"&redirect_uri=xxxx&auth_type=xxx。";
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








}
