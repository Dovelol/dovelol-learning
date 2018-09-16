package com.dove.lol.dovelol.demo.date201808.demo20180814.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author Dovelol
 * @date 2018/8/15 0:31
 */
public class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Objects.equals(method.getName(), "getNameById")) {
            return "yzh";
        }
        return null;
    }
}
