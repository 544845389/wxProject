package com.example.wxthird.service;

import com.example.wxthird.wxapi.model.ReqCreateSmallProgram;
import com.example.wxthird.wxapi.model.ReqFastregisterWeapp;
import com.example.wxthird.wxapi.model.ReqWxCodeCommit;

/**
 * @author 侯存路
 * @date 2018/12/13
 * @company codingApi
 * @description
 */
public interface WxSmallProgramService {



    String createSmallProgram(ReqCreateSmallProgram program);



    String searchSmallProgramState(ReqFastregisterWeapp reqFastregisterWeapp);



    String smallProgramCommit(String access_token , ReqWxCodeCommit reqWxCodeCommit);
}
