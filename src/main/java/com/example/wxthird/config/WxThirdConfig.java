package com.example.wxthird.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 侯存路
 * @date 2018/11/29
 * @company codingApi
 * @description
 */
@ConfigurationProperties(value = "wxthird")
public class WxThirdConfig {

    private  String appid;

    private  String appsecret;

    private  String aeskey;

    private  String token;



    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getAeskey() {
        return aeskey;
    }

    public void setAeskey(String aeskey) {
        this.aeskey = aeskey;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
