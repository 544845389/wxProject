package com.example.wxthird.wxapi.model;

/**
 * @author 侯存路
 * @date 2018/12/11
 * @company codingApi
 * @description
 */
public class ReqPreAuthCode {


    private   String  component_appid;


    public ReqPreAuthCode(String component_appid) {
        this.component_appid = component_appid;
    }

    public String getComponent_appid() {
        return component_appid;
    }

    public void setComponent_appid(String component_appid) {
        this.component_appid = component_appid;
    }
}
