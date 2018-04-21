package com.dove.lol.dovelol.demo.thread.date201804.demo20180407;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Dovelol
 * @date 2018/4/7 13:01
 */
public class DynamicProxyTest {

    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {
        @Override
        public void sayHello() {
            System.out.println("Hello World");
        }
    }

    static class DynamicProxy implements InvocationHandler {

        private Object object;

        Object bind(Object object) {
            this.object = object;
            return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
        }


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            System.out.println("Welcome!");
            return method.invoke(object, args);
        }
    }

    public static void main(String[] args) {
        IHello iHello = (IHello) new DynamicProxy().bind(new Hello());
        iHello.sayHello();

        System.out.println(((82765.34*2.5653-170000*1.05)*0.8+170000*1.05)*15/17);
    }


}
