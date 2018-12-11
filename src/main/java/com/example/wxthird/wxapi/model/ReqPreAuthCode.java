package com.example.wxthird.wxapi.model;

/**
 * @author 侯存路
 * @date 2018/12/11
 * @company codingApi
 * @description
 */
public class ReqPreAuthCode {


    private   String  componentAppId;

    public ReqPreAuthCode(String componentAppId) {
        this.componentAppId = componentAppId;
    }

    public String getComponentAppId() {
        return componentAppId;
    }

    public void setComponentAppId(String componentAppId) {
        this.componentAppId = componentAppId;
    }
}
