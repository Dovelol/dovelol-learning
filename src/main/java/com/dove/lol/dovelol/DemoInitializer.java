package com.dove.lol.dovelol;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Dovelol
 * @date 2019/3/6 22:40
 */
@Order(value = 100)
@Component
public class DemoInitializer implements ApplicationContextInitializer,Ordered {

    @Override
    public int getOrder() {
        return 0;
    }

    public DemoInitializer() {
        System.out.println("DemoInitializer构造器");
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("自定义DemoInitializer");
    }
}
