package com.example.wxthird.wxapi.model;

/**
 * @author 侯存路
 * @date 2018/12/13
 * @company codingApi
 * @description
 */
public class RegisterEventPushInfo {


    private  String name;


    private  String code;


    private  String code_type;


    private  String legal_persona_wechat;


    private  String legal_persona_name;


    private  String component_phone;


    public RegisterEventPushInfo(String name, String code, String code_type, String legal_persona_wechat, String legal_persona_name, String component_phone) {
        this.name = name;
        this.code = code;
        this.code_type = code_type;
        this.legal_persona_wechat = legal_persona_wechat;
        this.legal_persona_name = legal_persona_name;
        this.component_phone = component_phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode_type() {
        return code_type;
    }

    public void setCode_type(String code_type) {
        this.code_type = code_type;
    }

    public String getLegal_persona_wechat() {
        return legal_persona_wechat;
    }

    public void setLegal_persona_wechat(String legal_persona_wechat) {
        this.legal_persona_wechat = legal_persona_wechat;
    }

    public String getLegal_persona_name() {
        return legal_persona_name;
    }

    public void setLegal_persona_name(String legal_persona_name) {
        this.legal_persona_name = legal_persona_name;
    }

    public String getComponent_phone() {
        return component_phone;
    }

    public void setComponent_phone(String component_phone) {
        this.component_phone = component_phone;
    }
}
