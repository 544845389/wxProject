package com.example;

import com.example.wxthird.config.WxThirdConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WxthirdApplication {

	public static void main(String[] args) {
		SpringApplication.run(WxthirdApplication.class, args);
	}


	@Bean
	public  WxThirdConfig getWxThirdConfig(){
		return new WxThirdConfig() ;
	}



}
