package com.dove.lol.dovelol.demo.date202101.demo20210103;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Dovelol
 * @date 2021/1/3 16:57
 */
@Configuration
@EnableAspectJAutoProxy
public class AspectJAnnotatedDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(AspectJAnnotatedDemo.class,AspectConfiguration.class);

        context.refresh();

        AspectJAnnotatedDemo bean = context.getBean(AspectJAnnotatedDemo.class);
        String hello = bean.hello();
        System.out.println(hello);


    }

    public String hello(){
        return "hello";
    }

}
