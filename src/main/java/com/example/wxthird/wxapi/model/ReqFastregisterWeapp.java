package com.example.wxthird.wxapi.model;

/**
 * @author 侯存路
 * @date 2018/12/13
 * @company codingApi
 * @description
 */
public class ReqFastregisterWeapp {


    /**
     *  企业名
     */
    private  String name;


    /**
     *  法人微信
     */
    private  String legal_persona_wechat;


    /**
     *  法人姓名
     */
    private  String legal_persona_name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
