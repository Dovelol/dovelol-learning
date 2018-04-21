package com.dove.lol.dovelol.demo.date201803.demo20180326;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Dovelol
 * @date 2018/3/26 22:36
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object object = null;

    public Object bind(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object temp = method.invoke(this.object, args);
        return temp;
    }


}


interface Subject {
    public String say(String name, int age);
}

class RealSubject implements Subject {

    @Override
    public String say(String name, int age) {
        return name + ":" + age;
    }
}

class hello {

    public static void main(String[] args) throws ClassNotFoundException {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();

        Subject realSubject = (Subject) myInvocationHandler.bind(new RealSubject());
        String dove = realSubject.say("dove", 20);
        System.out.println(dove);

    }

}