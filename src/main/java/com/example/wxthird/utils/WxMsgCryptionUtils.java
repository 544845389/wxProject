package com.example.wxthird.utils;

import com.example.wxthird.config.WxThirdConfig;
import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author 侯存路
 * @date 2018/11/29
 * @company codingApi
 * @description   微信消息 加解密处理
 */
@Component
public class WxMsgCryptionUtils {


    private static WxMsgCryptionUtils factory;

    @Autowired
    private WxThirdConfig wxThirdConfig;


    @PostConstruct
    public void init() {
        factory = this;
        factory.wxThirdConfig = this.wxThirdConfig;
    }


    /**
     * 解密处理
     *
     * @return
     */
    public static String decryptCode(String msgSignature, String timestamp, String nonce, String fromXML) throws AesException {
        /**
         * 这里是微信的jar 中只有 ToUserName 的处理，而现在接受到的 是AppId 所以替换一下
         */
        fromXML =   fromXML.replaceAll("AppId" , "ToUserName");
        WXBizMsgCrypt pc = new WXBizMsgCrypt(factory.wxThirdConfig.getToken(), factory.wxThirdConfig.getAeskey(), factory.wxThirdConfig.getAppid());
        String result2 = pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
        System.out.println("解密后明文:>>>" + result2);
        return result2;
    }


    /**
     * 加密
     *
     * @return
     */
    public static String encryptionCode() {

//        https://blog.csdn.net/lwx0313/article/details/77164506  参考资料
        return "";
    }





}
