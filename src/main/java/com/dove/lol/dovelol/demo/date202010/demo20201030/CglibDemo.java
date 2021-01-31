package com.dove.lol.dovelol.demo.date202010;

import com.dove.lol.dovelol.demo.date202010.demo20201026.UserService;
import com.dove.lol.dovelol.model.User;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Dovelol
 * @date 2020/10/29 21:05
 */
public class CglibDemo {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("before method run...");
                Object result = proxy.invokeSuper(obj, args);
                System.out.println("after method run...");
                return result;
            }
        });
        UserService sample = (UserService) enhancer.create();
        User user = sample.getUserById(100L);
        System.out.println(user);


    }

}
