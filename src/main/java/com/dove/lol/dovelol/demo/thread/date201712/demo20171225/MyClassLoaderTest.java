package com.dove.lol.dovelol.demo.thread.date201712.demo20171225;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Dovelol
 * @date 2017/12/25 22:12
 */
public class MyClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader("MyClassLoader");
        Class<?> aClass = myClassLoader.loadClass("com.dove.lol.dovelol.demo.thread.date201712.demo20171225.MyObject");
        System.out.println(aClass);
        System.out.println(aClass.getClassLoader());

        Object obj = aClass.newInstance();
        Method hello = aClass.getMethod("hello", new Class[]{});
        Object object = hello.invoke(obj, new Object[]{});
        System.out.println(object);
    }

}
