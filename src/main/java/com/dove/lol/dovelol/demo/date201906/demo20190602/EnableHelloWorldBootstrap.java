package com.dove.lol.dovelol.demo.date201906.demo20190602;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dovelol
 * @date 2019/6/2 21:43
 */

//@EnableHelloWorld
@Configuration
public class EnableHelloWorldBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //context.register(EnableHelloWorldBootstrap.class);

        context.scan("com.dove.lol.dovelol.demo.date201906.*");

        context.refresh();

        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println(helloWorld);


    }


}
