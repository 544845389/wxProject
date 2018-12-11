package com.example.wxthird.wxapi.model;

/**
 * @author 侯存路
 * @date 2018/12/11
 * @company codingApi
 * @description
 */
public class ResPreAuthCode {



    private String pre_auth_code;


    private int  expires_in;


    public String getPre_auth_code() {
        return pre_auth_code;
    }

    public void setPre_auth_code(String pre_auth_code) {
        this.pre_auth_code = pre_auth_code;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
