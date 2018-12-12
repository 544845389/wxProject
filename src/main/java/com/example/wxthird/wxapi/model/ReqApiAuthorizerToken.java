package com.example.wxthird.wxapi.model;

/**
 * @author 侯存路
 * @date 2018/12/12
 * @company codingApi
 * @description
 */
public class ReqApiAuthorizerToken {


    public  String  component_appid;


    public  String authorizer_appid;


    public  String authorizer_refresh_token;


    public ReqApiAuthorizerToken(String component_appid, String authorizer_appid, String authorizer_refresh_token) {
        this.component_appid = component_appid;
        this.authorizer_appid = authorizer_appid;
        this.authorizer_refresh_token = authorizer_refresh_token;
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

    public String getAuthorizer_refresh_token() {
        return authorizer_refresh_token;
    }

    public void setAuthorizer_refresh_token(String authorizer_refresh_token) {
        this.authorizer_refresh_token = authorizer_refresh_token;
    }
}
