package com.dove.lol.dovelol.demo.date202010.demo20201026;

import com.dove.lol.dovelol.model.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Dovelol
 * @date 2020/10/26 23:04
 */
public class UserProxy implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("invoke start");
        User user = new User();
        user.setAge(10);
        user.setName("ddd");
        user.setId(1L);
        return user;
    }


    public Object newInstance(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class[]{UserService.class},this);
    }
}
