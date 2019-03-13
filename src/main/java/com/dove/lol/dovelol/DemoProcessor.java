package com.dove.lol.dovelol;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Dovelol
 * @date 2019/3/9 10:41
 */

@Component
public class DemoProcessor implements BeanPostProcessor {

    public DemoProcessor() {
        System.out.println("DemoProcessor构造器");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("自定义DemoProcessor before");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("自定义DemoProcessor after");
        return bean;
    }
}
