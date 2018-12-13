package com.example.wxthird.wxapi.model;

/**
 * @author 侯存路
 * @date 2018/12/13
 * @company codingApi
 * @description
 */
public class ReqCreateSmallProgram {



    /**
     *  企业名（需与工商部门登记信息一致）
     */
    private  String  name;

    /**
     * 企业代码
     */
    private  String  code;

    /**
     * 企业代码类型 1：统一社会信用代码（18位） 2：组织机构代码（9位xxxxxxxx-x） 3：营业执照注册号(15位)
     */
    private  String  code_type;

    /**
     * 法人微信号
     */
    private  String  legal_persona_wechat;


    /**
     * 法人姓名（绑定银行卡）
     */
    private  String  legal_persona_name;


    /**
     * 第三方联系电话（方便法人与第三方联系）
     */
    private  String  component_phone;




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
