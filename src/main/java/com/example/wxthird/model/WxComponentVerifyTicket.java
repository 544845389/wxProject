package com.example.wxthird.model;


import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * @author 侯存路
 * @date 2018/11/28
 * @company codingApi
 * @description
 */

@XmlRootElement(name = "xml")
public class WxComponentVerifyTicket{

    @XmlElement
    private  String  AppId;

    @XmlElement
    private  String  CreateTime;

    @XmlElement
    private  String  InfoType;

    @XmlElement
    private  String  ComponentVerifyTicket;

    public WxComponentVerifyTicket() {
    }

    public WxComponentVerifyTicket(String appId, String createTime, String infoType, String componentVerifyTicket) {
        AppId = appId;
        CreateTime = createTime;
        InfoType = infoType;
        ComponentVerifyTicket = componentVerifyTicket;
    }

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        appId = appId;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getInfoType() {
        return InfoType;
    }

    public void setInfoType(String infoType) {
        InfoType = infoType;
    }

    public String getComponentVerifyTicket() {
        return ComponentVerifyTicket;
    }

    public void setComponentVerifyTicket(String componentVerifyTicket) {
        ComponentVerifyTicket = componentVerifyTicket;
    }
}
