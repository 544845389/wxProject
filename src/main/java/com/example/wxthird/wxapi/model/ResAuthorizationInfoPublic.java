package com.example.wxthird.wxapi.model;

import java.util.List;

/**
 * @author 侯存路
 * @date 2018/12/12
 * @company codingApi
 * @description
 */
public class ResAuthorizationInfoPublic {


    private String authorization_appid;

    private String authorizer_refresh_token;

    private List<ResFuncscopeCategoryPublic> func_info;


    public String getAuthorizer_refresh_token() {
        return authorizer_refresh_token;
    }

    public void setAuthorizer_refresh_token(String authorizer_refresh_token) {
        this.authorizer_refresh_token = authorizer_refresh_token;
    }

    public String getAuthorization_appid() {
        return authorization_appid;
    }

    public void setAuthorization_appid(String authorization_appid) {
        this.authorization_appid = authorization_appid;
    }

    public List<ResFuncscopeCategoryPublic> getFunc_info() {
        return func_info;
    }

    public void setFunc_info(List<ResFuncscopeCategoryPublic> func_info) {
        this.func_info = func_info;
    }
}
