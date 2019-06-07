package com.dove.lol.dovelol.demo.date201906.demo20190607;

import com.dove.lol.dovelol.DemoInitializer;
import com.dove.lol.dovelol.DemoListener;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * @author Dovelol
 * @date 2019/6/7 11:24
 */
public class SpringFactoriesLoaderDemo {

    public static void main(String[] args) {
        List<String> demoListeners = SpringFactoriesLoader.loadFactoryNames(ContextDemo.class, Thread.currentThread().getContextClassLoader());
        System.out.println(demoListeners);
    }

}
