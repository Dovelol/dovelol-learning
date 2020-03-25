package com.dove.lol.dovelol.demo.date202003.demo20200324;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Dovelol
 * @date 2020/3/24 22:08
 */
@Configuration
@PropertySource("classpath:META-INF/default.properties")
public class ExternalConfigurationDependencySourceDemo {

    @Value("${user.id}")
    private Long id;

    @Value("${user.name}")
    private String name;

    @Value("${user.age}")
    private Integer age;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ExternalConfigurationDependencySourceDemo.class);

        context.refresh();

        ExternalConfigurationDependencySourceDemo demo = context.getBean(ExternalConfigurationDependencySourceDemo.class);

        System.out.println("demo.id:"+demo.id);

        System.out.println("demo.name:"+demo.name);

        System.out.println("demo.age:"+demo.age);



    }


}
