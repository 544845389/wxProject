package com.example.wxthird.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author 侯存路
 * @date 2018/12/11
 * @company codingApi
 * @description
 */
@Component
public class RedisUtils {


    private static  RedisUtils redisUtils;


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;



    @PostConstruct
    public void init() {
        redisUtils = this;
        redisUtils.redisTemplate = this.redisTemplate;
    }




    public  static  String   getValueForKeyAndExpire(String key){
        String value = "";
        ValueOperations<String , Object> valueOperations =  redisUtils.redisTemplate.opsForValue();
         Object o  =  valueOperations.get(key);
         if(!ObjectUtils.isEmpty(o)){
             value = o.toString();
             int  surplus =  redisUtils.redisTemplate.getExpire(key, TimeUnit.SECONDS ).intValue();
             if(surplus > 200) {
                 return  value;
             }
         }
         return  value;
    }





}
