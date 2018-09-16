package com.dove.lol.dovelol.demo.date201809.demo20180916;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author Dovelol
 * @date 2018/9/16 9:46
 */
public class ArrayListSample {

    public static void main(String[] args) {
        ArrayList list  = new ArrayList(5);
        //list.set(1,1);

        Integer i = new Integer(0);

        Integer.parseInt("123");
        int a = Integer.valueOf(123);
        System.out.println(list.getClass().getName());

        Method[] declaredMethods = list.getClass().getDeclaredMethods();
        list.clone();
        for (Method method : declaredMethods){
        }

    }

}
