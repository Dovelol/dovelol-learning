package com.dove.lol.dovelol.demo.date202010.demo20201030;

import com.dove.lol.dovelol.demo.date202010.demo20201026.UserService;
import com.dove.lol.dovelol.model.User;
import org.springframework.cglib.core.DebuggingClassWriter;
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
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\xm\\dovelol\\com\\dove\\lol\\dovelol\\demo\\date202010");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("before method run...");
                User user =new User();
                user.setId(10L);
                System.out.println("after method run...");
                return user;
            }
        });
        UserService sample = (UserService) enhancer.create();
        User user = sample.getUserById(100L);
        System.out.println(user);


    }

}
