package com.dove.lol.dovelol;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(DemoProperties.class)
@MapperScan("com.dove.lol.dovelol.mapper")
public class DovelolApplication {

	public static void main(String[] args) {
		SpringApplication.run(DovelolApplication.class, args);


//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.register(DovelolApplication.class);
//		context.refresh();
//		Object handler = context.getBean("handler");
//		Object b = context.getBean("b");
	}
}
