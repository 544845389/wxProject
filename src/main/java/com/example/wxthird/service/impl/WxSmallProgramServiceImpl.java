package com.example.wxthird.service.impl;

import com.example.wxthird.service.WxService;
import com.example.wxthird.service.WxSmallProgramService;
import com.example.wxthird.wxapi.WxSmallProgramApi;
import com.example.wxthird.wxapi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 侯存路
 * @date 2018/12/13
 * @company codingApi
 * @description
 */
@Service
public class WxSmallProgramServiceImpl implements WxSmallProgramService {


    @Autowired
    private WxService wxService;



    @Override
    public String createSmallProgram(ReqCreateSmallProgram program) {
        ResCreateSmallProgram resCreateSmallProgram =  WxSmallProgramApi.createSmallProgram(wxService.getComponentAccessToken() ,program );
        return resCreateSmallProgram.toString();
    }




    @Override
    public String searchSmallProgramState(ReqFastregisterWeapp reqFastregisterWeapp) {
        ResFastregisterWeapp resFastregisterWeapp =  WxSmallProgramApi.fastregisterWeapp(wxService.getComponentAccessToken() ,reqFastregisterWeapp );
        return resFastregisterWeapp.toString();
    }



    @Override
    public String smallProgramCommit(String access_token , ReqWxCodeCommit reqWxCodeCommit) {
        ResWxCodeCommit resWxCodeCommit =  WxSmallProgramApi.wxCodeCommit(access_token ,  reqWxCodeCommit);
        return resWxCodeCommit.toString();
    }
}
