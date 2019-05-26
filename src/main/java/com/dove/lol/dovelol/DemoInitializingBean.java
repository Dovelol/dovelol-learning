package com.dove.lol.dovelol;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author Dovelol
 * @date 2019/5/22 22:07
 */
public class DemoInitializingBean implements InitializingBean{

    public DemoInitializingBean() {
        System.out.println("DemoInitializingBean构造器");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("DemoInitializingBean afterPropertiesSet");
    }
}
