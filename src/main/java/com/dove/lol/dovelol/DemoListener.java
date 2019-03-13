package com.dove.lol.dovelol;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Dovelol
 * @date 2019/3/6 23:22
 */
@Component
public class DemoListener implements ApplicationListener<ContextRefreshedEvent> {

    public DemoListener() {
        System.out.println("DemoListener构造器");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("我的父容器为：" + contextRefreshedEvent.getApplicationContext().getParent());
        System.out.println("初始化时我被调用了。");
    }
}
