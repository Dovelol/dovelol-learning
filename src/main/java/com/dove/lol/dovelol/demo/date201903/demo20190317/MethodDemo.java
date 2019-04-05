package com.dove.lol.dovelol.demo.date201903.demo20190317;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Dovelol
 * @date 2019/3/17 20:11
 */
public class MethodDemo {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MethodDemo methodDemo = new MethodDemo();
        Method test = MethodDemo.class.getMethod("test", String.class);
        Object yzh = test.invoke(methodDemo, "yzh");
        System.out.println(yzh);
    }

    public static String test(String value) {
        return "Hello World! " + value;
    }


}
