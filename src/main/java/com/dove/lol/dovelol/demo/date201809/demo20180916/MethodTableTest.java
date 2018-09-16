package com.dove.lol.dovelol.demo.date201809.demo20180916;

import java.lang.reflect.Method;

/**
 * @author Dovelol
 * @date 2018/9/16 16:33
 */
public class MethodTableTest {

    public static void main(String[] args) {
        try {
            Method square = MethodTableTest.class.getMethod("square", double.class);
            Method aqrt = Math.class.getMethod("sqrt", double.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


    public static double square(double x) {
        return x * x;
    }

}
