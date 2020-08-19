package com.dove.lol.dovelol.demo.date202008.demo20200816;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author Dovelol
 * @date 2020/7/12 16:43
 */
@EnableConfigurationProperties(AppProperties.class)
public class Demo0816 {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Demo0816.class);

        context.refresh();

        Environment bean = context.getBean(Environment.class);
        System.out.println("=================");
        System.out.println(bean);


        AppProperties app = context.getBean(AppProperties.class);
        System.out.println(app.getName()+"_"+app.getVersion());

        context.close();

    }

}
