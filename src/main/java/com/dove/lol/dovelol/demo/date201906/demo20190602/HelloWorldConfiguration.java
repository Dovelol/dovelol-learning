package com.dove.lol.dovelol.demo.date201906.demo20190602;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dovelol
 * @date 2019/6/2 21:48
 */

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld(){
        return "Hello,World";
    }

}
