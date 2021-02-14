package com.dove.lol.dovelol.demo.date202101.demo20210103;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dovelol
 * @date 2021/1/3 12:40
 */
public class AspectJAnnotationUseingApiDemo {

    public static void main(String[] args) {

        Map<String,Object> cache = new HashMap<>();

        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(cache);
        proxyFactory.addAspect(AspectConfiguration.class);
        proxyFactory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                if("put".equalsIgnoreCase(method.getName()) && args.length == 2){
                    System.out.printf("当前存放 key: %s value: %s\n", args[0],args[1]);
                }
            }
        });


        Map<String,Object> proxy = proxyFactory.getProxy();
        proxy.put("1","A");
        System.out.println(proxy.get("1"));

    }
}
