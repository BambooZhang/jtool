package com.bamboo.demo;

import com.bamboo.common.aspectj.SynLockrAspect;
import com.bamboo.common.aspectj.annotation.SynLockr;
import com.bamboo.common.autoconfigure.bamboo.BambooServer;
import com.bamboo.common.autoconfigure.redis.RedisClient;
import com.bamboo.common.config.CorsConfig;
import com.bamboo.common.config.LogFilter;
import com.bamboo.common.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@SpringBootApplication
@RestController
@Import(value = {CorsConfig.class, LogFilter.class, SynLockrAspect.class}) //跨域,接口访问请求日志
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private BambooServer bambooServer;//自定义autoconfig服务

	@Autowired
	private RedisClient redisClient;//自定义RedisClient服务
	@RequestMapping("/")
	public Object index(){
		return "helll demo"+bambooServer.getName()+DateUtils.getDate();
	}


	@RequestMapping("/redis")
	public Object redis(){
		redisClient.set("test","bamboo");
		return redisClient.get("test");
	}


	@RequestMapping("/syLock/{uid}")
	@SynLockr(path = "syn:test:%s", indexProps = {"0"})
	public Object synLock(@PathVariable("uid")Integer uid){
		redisClient.set("test",uid.toString());
		try {
			Thread.sleep(5000);//停顿5秒
		}catch (Exception e){

		}

		return redisClient.get("test");
	}
}
