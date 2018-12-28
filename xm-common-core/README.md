

## 常用通用方法集合

```
├─base
├─beanvalidator
├─cache
├─config
├─constant
├─entity
├─exception
├─http
│  ├─request
│  └─response
└─utils
    └─email
```

maven 依赖

```
		 <dependency>
			<groupId>com.bamboo</groupId>
			<artifactId>xm-common-core</artifactId>
			<version>0.0.1-SNAPSHOT</version>
		</dependency> 
```


例如，spring-boot web项目启动类

```

@SpringBootApplication
@RestController
@Import(value = {CorsConfig.class, LogFilter.class}) //跨域,接口访问请求日志
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	public Object index(){
		return "helll demo"+DateUtils.getDate();
	}
}
```

import 实现可跨域和日志请求拦截处理



redis配置
```

    redis:
        host: localhost
        port: 6379
        timeout: 2000
        password: redis
        database: 0
        timeout: 2000
        maxIdle: 10
        maxTotal: 100
        

```
个别属性如果不配置默认和上面一样,password默认是空值