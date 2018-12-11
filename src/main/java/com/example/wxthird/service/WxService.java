package com.example.wxthird.service;

/**
 * @author 侯存路
 * @date 2018/11/29
 * @company codingApi
 * @description
 */
public interface WxService {


    /**
     * 接收 Ticket
     * @param timestamp
     * @param nonce
     * @param msgSignature
     * @param postData
     */
   void getTicket (String timestamp , String nonce ,String  msgSignature ,String  postData );



    /**
     *  获取  PreAuthCode
     */
    String getPreAuthCode();


    /**
     * 获取  component_access_token
     * @return
     */
    String  getComponentAccessToken();







    String getScanCodeAuthorization();
}
