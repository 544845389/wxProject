package com.example.wxthird.wxapi.model;

import org.apache.commons.collections.MapUtils;

import java.util.Map;

/**
 * @author 侯存路
 * @date 2018/12/13
 * @company codingApi
 * @description
 */
public class RegisterEventPush {


    private  String appId;

    private  String createTime;

    private  String infoType;

    private  String appid;

    private  int status;

    private  String auth_code;

    private  String msg;

    private  RegisterEventPushInfo info;


    public RegisterEventPush(Map<String,Object> map) {
        this.appId  =  map.get("AppId").toString();
        this.createTime = map.get("CreateTime").toString();
        this.infoType =  map.get("InfoType").toString();
        this.appid =  map.get("appid").toString();
        this.status =  Integer.parseInt(map.get("status").toString());
        this.auth_code =  map.get("auth_code").toString();
        this.msg =  map.get("msg").toString();

        Map<String,String> infoMap =  MapUtils.getMap(map , "info");

        this.info = new RegisterEventPushInfo(infoMap.get("name") , infoMap.get("code") , infoMap.get("code_type") ,
                infoMap.get("legal_persona_wechat") , infoMap.get("legal_persona_name") , infoMap.get("component_phone"));
    }


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RegisterEventPushInfo getInfo() {
        return info;
    }

    public void setInfo(RegisterEventPushInfo info) {
        this.info = info;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }
}
