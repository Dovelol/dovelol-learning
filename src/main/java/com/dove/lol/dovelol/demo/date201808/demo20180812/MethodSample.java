package com.dove.lol.dovelol.demo.date201808.demo20180812;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Dovelol
 * @date 2018/8/12 16:32
 */
public class MethodSample {

    public static void main(String[] args) {
        try {
            MethodHandle methodHandle = MethodHandles.lookup().findVirtual(String.class, "toString", MethodType.methodType(String.class));
            System.out.println(methodHandle.invoke("acb"));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        try {
            Method method = String.class.getMethod("toString");
            Object abc = method.invoke("abc");
            System.out.println(abc);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
