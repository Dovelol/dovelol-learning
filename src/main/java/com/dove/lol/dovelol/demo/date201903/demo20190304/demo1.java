package com.dove.lol.dovelol.demo.date201903.demo20190304;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Dovelol
 * @date 2019/3/4 21:48
 */
public class demo1 {

    public static void main(String[] args) {
        ConcurrentHashMap<Integer,String> map = new ConcurrentHashMap<>();

        map.put(1,"11");
        map.put(2,"22");
        map.put(3,"33");

//        while (true){
//            Enhancer enhancer = new Enhancer() ;
//            enhancer.setSuperclass(demo1.class);
//            enhancer.setUseCache(false) ;
//            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invoke(o,objects));
//            enhancer.create() ;
//
//        }

    }



}
