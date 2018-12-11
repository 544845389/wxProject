package com.example.wxthird.wxapi.model;

/**
 * @author 侯存路
 * @date 2018/12/11
 * @company codingApi
 * @description
 */
public class ReqComponentToken {


    private    String  component_appid;


    private    String  component_appsecret;


    private    String  component_verify_ticket;


    public ReqComponentToken(String component_appid, String component_appsecret, String component_verify_ticket) {
        this.component_appid = component_appid;
        this.component_appsecret = component_appsecret;
        this.component_verify_ticket = component_verify_ticket;
    }

    public String getComponent_appid() {
        return component_appid;
    }

    public void setComponent_appid(String component_appid) {
        this.component_appid = component_appid;
    }

    public String getComponent_appsecret() {
        return component_appsecret;
    }

    public void setComponent_appsecret(String component_appsecret) {
        this.component_appsecret = component_appsecret;
    }

    public String getComponent_verify_ticket() {
        return component_verify_ticket;
    }

    public void setComponent_verify_ticket(String component_verify_ticket) {
        this.component_verify_ticket = component_verify_ticket;
    }
}
