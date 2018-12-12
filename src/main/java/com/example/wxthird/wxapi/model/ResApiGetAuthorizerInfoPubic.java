package com.example.wxthird.wxapi.model;

/**
 * @author 侯存路
 * @date 2018/12/12
 * @company codingApi
 * @description
 */
public class ResApiGetAuthorizerInfoPubic {


    private   ResAuthorizerInfo  authorizer_info;


    private  ResAuthorizationInfoPublic authorization_info;


    public ResAuthorizerInfo getAuthorizer_info() {
        return authorizer_info;
    }

    public void setAuthorizer_info(ResAuthorizerInfo authorizer_info) {
        this.authorizer_info = authorizer_info;
    }

    public ResAuthorizationInfoPublic getAuthorization_info() {
        return authorization_info;
    }

    public void setAuthorization_info(ResAuthorizationInfoPublic authorization_info) {
        this.authorization_info = authorization_info;
    }
}
