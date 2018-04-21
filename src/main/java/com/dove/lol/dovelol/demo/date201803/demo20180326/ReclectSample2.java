package com.dove.lol.dovelol.demo.date201803.demo20180326;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

/**
 * @author Dovelol
 * @date 2018/3/26 22:23
 */
public class ReclectSample2 {

    public static void main(String[] args) throws ClassNotFoundException {
        int[] temp = {1, 2, 3, 4, 5, 6};
        int length = temp.length;
        Class<?> componentType = temp.getClass();
        System.out.println(componentType.getName());
        System.out.println(Array.getLength(temp));

        System.out.println(Integer.TYPE);
        System.out.println(new Integer(1).getClass().getName());
        System.out.println(Integer.class);
        System.out.println(Class.forName("java.lang.Integer"));


        Class clazz = Integer.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {

            System.out.println(declaredMethods[i].getName());
        }

    }

}
