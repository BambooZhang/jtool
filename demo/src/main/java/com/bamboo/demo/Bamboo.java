package com.bamboo.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "test")
//@Component //如果这里添加了注解那么在自动配置类的时候就不用添加@enableConfigurationProperties(HelloProperties.class)注解.
public class Bamboo {

 
	
    private String msg="default";//现在我们在配置文件写hello.msg=world,因为简单就不再展示;如果那么默认为default.

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
	}
	
	
	@RequestMapping("/msg")
	public Object index(){
		return this.msg;
	}

}
