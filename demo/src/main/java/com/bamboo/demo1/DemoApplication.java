package com.bamboo.demo1;

import com.bamboo.common.autoconfigure.bamboo.BambooServer;
import com.bamboo.common.config.CorsConfig;
import com.bamboo.common.config.LogFilter;
import com.bamboo.common.utils.DateUtils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@Import(value = {CorsConfig.class, LogFilter.class}) //跨域,接口访问请求日志
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private BambooServer bambooServer;//自定义autoconfig服务
	@RequestMapping("/")
	public Object index(){
		return "helll demo"+bambooServer.getName()+DateUtils.getDate();
	}
}
