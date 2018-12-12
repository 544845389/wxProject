package com.example.wxthird.wxapi.model;

/**
 * @author 侯存路
 * @date 2018/12/12
 * @company codingApi
 * @description
 */
public class ResAuthorizerInfo {


    private  String nick_name;

    private  String head_img;

    private  String user_name;

    private  String principal_name;

    private  String alias;

    private  String qrcode_url;

    private  ResServiceTypeInfo service_type_info;

    private  ResVerifyTypeInfo  verify_type_info;

    private  ResBusinessInfo  business_info;

    private  int idc;

    private  String signature;

    private  ResMiniProgramInfo MiniProgramInfo;

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPrincipal_name() {
        return principal_name;
    }

    public void setPrincipal_name(String principal_name) {
        this.principal_name = principal_name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getQrcode_url() {
        return qrcode_url;
    }

    public void setQrcode_url(String qrcode_url) {
        this.qrcode_url = qrcode_url;
    }

    public ResServiceTypeInfo getService_type_info() {
        return service_type_info;
    }

    public void setService_type_info(ResServiceTypeInfo service_type_info) {
        this.service_type_info = service_type_info;
    }

    public ResVerifyTypeInfo getVerify_type_info() {
        return verify_type_info;
    }

    public void setVerify_type_info(ResVerifyTypeInfo verify_type_info) {
        this.verify_type_info = verify_type_info;
    }

    public ResBusinessInfo getBusiness_info() {
        return business_info;
    }

    public void setBusiness_info(ResBusinessInfo business_info) {
        this.business_info = business_info;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public ResMiniProgramInfo getMiniProgramInfo() {
        return MiniProgramInfo;
    }

    public void setMiniProgramInfo(ResMiniProgramInfo miniProgramInfo) {
        MiniProgramInfo = miniProgramInfo;
    }
}
