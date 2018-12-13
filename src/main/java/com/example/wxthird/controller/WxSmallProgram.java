package com.example.wxthird.controller;

import com.example.wxthird.service.WxSmallProgramService;
import com.example.wxthird.wxapi.model.ReqCreateSmallProgram;
import com.example.wxthird.wxapi.model.ReqFastregisterWeapp;
import com.example.wxthird.wxapi.model.ReqWxCodeCommit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 侯存路
 * @date 2018/12/13
 * @company codingApi
 * @description
 */
@RestController
@RequestMapping("/wx/small")
public class WxSmallProgram {


    @Autowired
    private WxSmallProgramService  wxSmallProgramService;


    /**
     *  创建小程序接口
     * @param name
     * @param code
     * @param code_type
     * @param legal_persona_wechat
     * @param legal_persona_name
     * @param component_phone
     * @return
     */
    @GetMapping("/createSmallProgram")
    public  String   fastregisterweapp (
            @RequestParam("name") String name ,
            @RequestParam("code") String code ,
            @RequestParam("code_type") String code_type ,
            @RequestParam("legal_persona_wechat") String legal_persona_wechat ,
            @RequestParam("legal_persona_name") String legal_persona_name ,
            @RequestParam("component_phone") String component_phone
    ){
        ReqCreateSmallProgram  program = new ReqCreateSmallProgram();
        program.setName(name);
        program.setCode(code);
        program.setCode_type(code_type);
        program.setLegal_persona_wechat(legal_persona_wechat);
        program.setLegal_persona_name(legal_persona_name);
        program.setComponent_phone(component_phone);
       return   wxSmallProgramService.createSmallProgram(program);
    }


    /**
     *  查询创建任务状态
     */
    @GetMapping("/searchSmallProgramState")
    public  String   searchSmallProgramState(
            @RequestParam("name") String name ,
            @RequestParam("legal_persona_wechat") String legal_persona_wechat ,
            @RequestParam("legal_persona_name") String legal_persona_name
            ){

        ReqFastregisterWeapp weapp = new ReqFastregisterWeapp();
        weapp.setName(name);
        weapp.setLegal_persona_name(legal_persona_name);
        weapp.setLegal_persona_wechat(legal_persona_wechat);
        return wxSmallProgramService.searchSmallProgramState(weapp);
    }



    /**
     *  为授权的小程序帐号上传小程序代码
     */
    @GetMapping("/smallProgramCommit")
    public void SmallProgramCommit(
           @RequestParam("access_token") String access_token ,
           @RequestParam("template_id") String template_id ,
           @RequestParam("ext_json") String ext_json ,
           @RequestParam("user_version") String user_version ,
           @RequestParam("user_desc") String user_desc
           ) {

        ReqWxCodeCommit reqWxCodeCommit = new ReqWxCodeCommit();
        reqWxCodeCommit.setTemplate_id(template_id);
        reqWxCodeCommit.setExt_json(ext_json);
        reqWxCodeCommit.setUser_version(user_version);
        reqWxCodeCommit.setUser_desc(user_desc);
        wxSmallProgramService.smallProgramCommit(access_token , reqWxCodeCommit);
    }



}
