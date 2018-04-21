package com.dove.lol.dovelol.demo.date201803.demo20180325;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author Dovelol
 * @date 2018/3/25 23:35
 */
public class ReflectSample {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Demo demo = new Demo();
        System.out.println(Demo.class.getName());
        System.out.println(demo.getClass().getName());

        try {
            Class<?> demoClass = Class.forName(demo.getClass().getName());
            System.out.println(demoClass.getName());

            Constructor<?>[] constructors = Demo.class.getConstructors();
            Constructor<?> constructor = constructors[0];
            constructor.newInstance();
            Demo demo1 = Demo.class.newInstance();
            System.out.println(demo1.i);

            Integer i = new Integer(0);

            ArrayList integer = ArrayList.class.newInstance();

            System.out.println(integer);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        Class<?>[] interfaces = ArrayList.class.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println(interfaces[i].getSuperclass());
        }

        Method test = Demo.class.getMethod("test");
        test.invoke(Demo.class.newInstance());

    }
}

class Demo {
    int i = 10;

    public Demo() {
    }

    public Demo(int i) {
        this.i = i;
    }


    public void test() {
        System.out.println("test");
    }
}
