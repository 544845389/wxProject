package com.example.wxthird.wxapi.model;

/**
 * @author 侯存路
 * @date 2018/12/11
 * @company codingApi
 * @description
 */
public class ReqApiQueryAuth {


    private  String component_appid;


    private  String authorization_code;


    public ReqApiQueryAuth(String component_appid, String authorization_code) {
        this.component_appid = component_appid;
        this.authorization_code = authorization_code;
    }

    public String getComponent_appid() {
        return component_appid;
    }

    public void setComponent_appid(String component_appid) {
        this.component_appid = component_appid;
    }

    public String getAuthorization_code() {
        return authorization_code;
    }

    public void setAuthorization_code(String authorization_code) {
        this.authorization_code = authorization_code;
    }


}
