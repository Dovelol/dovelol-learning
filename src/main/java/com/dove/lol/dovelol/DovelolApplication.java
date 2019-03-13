package com.dove.lol.dovelol;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dove.lol.dovelol.mapper")
public class DovelolApplication {

	public static void main(String[] args) {
		SpringApplication.run(DovelolApplication.class, args);
	}
}
