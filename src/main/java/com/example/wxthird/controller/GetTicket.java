package com.example.wxthird.controller;

import com.example.wxthird.utils.WxMsgCryptionUtils;
import com.lorne.core.framework.utils.DateUtil;
import com.qq.weixin.mp.aes.AesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * 获取 微信发送过来的 Ticket
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

        System.out.println("timestamp = " + timestamp);
        System.out.println("nonce = " + nonce);
        System.out.println("msg_signature = " + msgSignature);
        System.out.println("postData = " + postData);
        System.out.println(DateUtil.formatDate(new Date() , DateUtil.FULL_DATE_TIME_FORMAT));

        String  res = null;
        try {
            res = WxMsgCryptionUtils.decryptCode(msgSignature ,timestamp , nonce , postData );
        } catch (AesException e) {
            System.out.println(" Ticket 解密失败 " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("res = " + res);

        //redisTemplate.opsForValue().set("ticket" , wxComponentVerifyTicket.getComponentVerifyTicket());
        return  "success";
    }


}
