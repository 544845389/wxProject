package com.example.wxthird.controller;

import com.example.wxthird.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 侯存路
 * @date 2018/11/28
 * @company codingApi
 * @description
 */
@RestController
@RequestMapping("/wx/gm/authorization")
public class GetTicket {


    @Autowired
    private WxService wxService;


    /**
     * 获取 微信发送过来的 消息
     * @param timestamp
     * @param nonce
     * @param msgSignature
     * @param postData
     * @return
     */
    @RequestMapping( value = "/info")
    public String getTicket (@RequestParam("timestamp") String timestamp,
                             @RequestParam("nonce") String nonce,
                             @RequestParam("msg_signature") String msgSignature,
                             @RequestBody String postData){
        System.out.println("timestamp-->"+timestamp+"/ nonce-->"+nonce +" / msg_signature-->"+msgSignature+" / postData-->"+postData);
        wxService.getTicket(timestamp , nonce , msgSignature , postData);
        return  "success";
    }


}
