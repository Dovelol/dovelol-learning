package com.dove.lol.dovelol.demo.date201904.demo20190421;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Dovelol
 * @date 2019/4/21 22:45
 */
public class ReflectDemo {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<ReflectDemo> reflectDemoClass = ReflectDemo.class;
        ReflectDemo reflectDemo = reflectDemoClass.newInstance();

        Object o = ReflectDemo.class.getConstructors()[0].newInstance(null);
    }

}
