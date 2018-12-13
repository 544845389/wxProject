package com.example.wxthird.wxapi;

import com.alibaba.fastjson.JSON;
import com.example.wxthird.wxapi.model.*;
import com.lorne.core.framework.utils.http.HttpUtils;
import org.springframework.util.ObjectUtils;

/**
 * @author 侯存路
 * @date 2018/12/13
 * @company codingApi
 * @description 第三方平台 代小程序实现业务
 */
public class WxSmallProgramApi {


    /**
     * 创建小程序接口
     */
    private static String FASTREGISTERWEAPP = "https://api.weixin.qq.com/cgi-bin/component/fastregisterweapp?action=create&component_access_token=";


    /**
     *  查询创建任务状态
     */
    private static String SEARCHFASTREGISTERWEAPP ="https://api.weixin.qq.com/cgi-bin/component/fastregisterweapp?action=search&component_access_token=";



    /**
     *  为授权的小程序帐号上传小程序代码
     */
    private static String commit ="https://api.weixin.qq.com/wxa/commit?access_token=";



    /**
     *  获取体验小程序的体验二维码
     */
    private static String getQrcode ="https://api.weixin.qq.com/wxa/get_qrcode?access_token=";






    /**
     * 创建小程序接口
     */
    public static ResCreateSmallProgram createSmallProgram(String componentAccessToken, ReqCreateSmallProgram reqCreateSmallProgram) {
        String url = FASTREGISTERWEAPP + componentAccessToken;
        String json = HttpUtils.postJson(url, JSON.toJSONString(reqCreateSmallProgram));
        System.out.println(" WxSmallProgramApi -- > ResCreateSmallProgram --> " + json);
        ResCreateSmallProgram resCreateSmallProgram = JSON.parseObject(json, ResCreateSmallProgram.class);
        if (ObjectUtils.isEmpty(resCreateSmallProgram.getErrcode())) {
            throw new NullPointerException("createSmallProgram 获取失败！" + json);
        }
        return resCreateSmallProgram;
    }



    /**
     *  查询创建任务状态
     */
    public  static ResFastregisterWeapp fastregisterWeapp(String componentAccessToken, ReqFastregisterWeapp reqFastregisterWeapp ){
        String url = SEARCHFASTREGISTERWEAPP + componentAccessToken;
        String json = HttpUtils.postJson(url, JSON.toJSONString(reqFastregisterWeapp));
        System.out.println(" WxSmallProgramApi -- > fastregisterWeapp --> " + json);
        ResFastregisterWeapp resCreateSmallProgram = JSON.parseObject(json, ResFastregisterWeapp.class);
        if (ObjectUtils.isEmpty(resCreateSmallProgram.getErrcode())) {
            throw new NullPointerException("fastregisterWeapp  获取失败！" + json);
        }
        return resCreateSmallProgram;
    }


    /**
     *  为授权的小程序帐号上传小程序代码
     */
    public  static ResWxCodeCommit   wxCodeCommit(String  accessToken , ReqWxCodeCommit reqWxCodeCommit){
        String url = commit  + accessToken;
        String json = HttpUtils.postJson(url, JSON.toJSONString(reqWxCodeCommit));
        System.out.println(" WxSmallProgramApi -- > wxCodeCommit --> " + json);
        ResWxCodeCommit resWxCodeCommit = JSON.parseObject(json, ResWxCodeCommit.class);
        if (ObjectUtils.isEmpty(resWxCodeCommit.getErrcode())) {
            throw new NullPointerException("fastregisterWeapp  获取失败！" + json);
        }
        return  resWxCodeCommit;
    }



    /**
     * 获取体验小程序的体验二维码
     */
    public  static void  getQrcode(String accessToken){

    }


}
