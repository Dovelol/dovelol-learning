package com.dove.lol.dovelol;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Dovelol
 * @date 2019/3/9 10:04
 */
@Component
public class DemoAware implements ApplicationContextAware{

    public DemoAware() {
        System.out.println("DemoAware构造器");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("自定义DemoAware");
    }
}
