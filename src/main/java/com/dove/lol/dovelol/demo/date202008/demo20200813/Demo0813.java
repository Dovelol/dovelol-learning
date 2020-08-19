package com.dove.lol.dovelol.demo.date202008.demo20200813;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author Dovelol
 * @date 2020/7/12 16:43
 */
public class Demo0813 {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Demo0813.class);

        context.refresh();

        Environment bean = context.getBean(Environment.class);
        System.out.println("=================");
        System.out.println(bean);

        context.close();

    }

}
