package com.example.wxthird;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lorne.core.framework.utils.http.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 侯存路
 * @date 2018/11/28
 * @company codingApi
 * @description
 */
@Controller
@RequestMapping("/wx")
public class Demo {


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;



    private String appid = "wx9c258d18873a90f9";
    private String appsecret = "4e95154188f2cf38a3030a232b6e7d4b";
    private String token = "wx3e******165c";
    private String encodingAesKey = "wx3e******165c";
    private String component_ticket= "wx3e******165c";




    /**
     * 授权注册页面扫码授权
     * @return
     */
    @ResponseBody
    @RequestMapping("/componentLoginPage")
    public  void componentLoginPage(){
//        String url = "https://mp.weixin.qq.com/cgi-bin/componentloginpage?component_appid="+appid+"&pre_auth_code="++"&redirect_uri=xxxx&auth_type=xxx。";
    }


    
    
    /**
     * 获取 PreAuthCode
     * @return
     */
    private  String   getPreAuthCode(){
        String component_access_token = redisTemplate.opsForValue().get("component_access_token").toString();
        System.out.println("component_access_token = " + component_access_token);

        Map<String,String> map = new HashMap<>();
        map.put("component_appid", appid);

        String url = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token="+component_access_token;
        String json  =  HttpUtils.postJson(url , JSON.toJSONString(map));
        System.out.println("json = " + json);
        JSONObject jsonObject =  JSON.parseObject(json);
        String   pre_auth_code  =  jsonObject.getString("pre_auth_code");
        return  pre_auth_code;
    }







    



}
