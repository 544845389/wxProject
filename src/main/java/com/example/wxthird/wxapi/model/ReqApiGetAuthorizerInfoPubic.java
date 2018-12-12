package com.example.wxthird.wxapi.model;

/**
 * @author 侯存路
 * @date 2018/12/12
 * @company codingApi
 * @description
 */
public class ReqApiGetAuthorizerInfoPubic {


    public  String  component_appid;


    public  String authorizer_appid;


    public ReqApiGetAuthorizerInfoPubic(String component_appid, String authorizer_appid) {
        this.component_appid = component_appid;
        this.authorizer_appid = authorizer_appid;
    }

    public String getComponent_appid() {
        return component_appid;
    }

    public void setComponent_appid(String component_appid) {
        this.component_appid = component_appid;
    }

    public String getAuthorizer_appid() {
        return authorizer_appid;
    }

    public void setAuthorizer_appid(String authorizer_appid) {
        this.authorizer_appid = authorizer_appid;
    }
}
