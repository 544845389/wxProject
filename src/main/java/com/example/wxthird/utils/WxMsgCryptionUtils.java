package com.example.wxthird.utils;

import com.example.wxthird.config.WxThirdConfig;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author 侯存路
 * @date 2018/11/29
 * @company codingApi
 * @description   微信消息 加解密处理
 */
public class WxMsgCryptionUtils {


    private static WxMsgCryptionUtils factory;

    @Autowired
    private   WxThirdConfig  wxThirdConfig;


    @PostConstruct
    public void init() {
        factory = this;
    }



    /**
     * 解密处理
     * @return
     */
    public  static String decryptCode(String msgSignature ,String  timestamp , String nonce ,String fromXML) throws AesException {
        WXBizMsgCrypt pc = new WXBizMsgCrypt(factory.wxThirdConfig.getToken(), factory.wxThirdConfig.getAeskey(), factory.wxThirdConfig.getAppid());
        String result2 = pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
        System.out.println("解密后明文:>>>"+result2);
        return result2;
    }






}
