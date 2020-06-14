package com.dove.lol.dovelol;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Dovelol
 * @date 2019/3/6 23:22
 */
@Component
public class DemoListener1  implements ApplicationListener, ApplicationContextAware {

    private ApplicationContext applicationContext;

    public DemoListener1() {
        System.out.println("DemoListener1构造器");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("DemoListener1初始化时我被调用了。");
    }
}
