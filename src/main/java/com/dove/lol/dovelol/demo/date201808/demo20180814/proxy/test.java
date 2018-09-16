package com.dove.lol.dovelol.demo.date201808.demo20180814.proxy;

import java.lang.reflect.Proxy;

/**
 * @author Dovelol
 * @date 2018/8/15 0:33
 */
public class test {

    public static void main(String[] args) {
        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class<?>[]{UserMapper.class}, new MyInvocationHandler());
        System.out.println(userMapper.getNameById());
    }
}
