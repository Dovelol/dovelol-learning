package com.dove.lol.dovelol.demo.date202004.demo20200421;

import java.io.InputStream;
import java.util.ServiceLoader;

/**
 * @author Dovelol
 * @date 2020/4/21 23:19
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream demo1 = loader.getResourceAsStream("META-INF/spring.factories");
        InputStream demo2 = loader.getResourceAsStream("META-INF/org.apache.rocketmq.broker.transaction");
        InputStream demo3 = loader.getResourceAsStream("META-INF/org.apache.rocketmq.broker.transaction.AbstractTransactionalMessageCheckListener");


    }

}
