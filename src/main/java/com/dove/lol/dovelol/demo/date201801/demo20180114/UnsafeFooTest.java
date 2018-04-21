package com.dove.lol.dovelol.demo.date201801.demo20180114;

import sun.misc.Unsafe;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;

/**
 * @author Dovelol
 * @date 2018/1/14 9:57
 */
public class UnsafeFooTest {

    private static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
//        Simple simple = new Simple();
//        System.out.println(simple.get());

        //Simple simple1 = Simple.class.newInstance();

        Unsafe unsafe = getUnsafe();
//        Simple simple = (Simple)unsafe.allocateInstance(Simple.class);
//        System.out.println(simple.get());
//        System.out.println(simple.getClass());
//        System.out.println(simple.getClass().getClassLoader());

        Guard guard = new Guard();

        Field field = Guard.class.getDeclaredField("ACCESS_ALLOWED");
        unsafe.putInt(guard, unsafe.objectFieldOffset(field), 42);
//        field.setAccessible(true);
//        field.set(guard,42);
        guard.work();

    }

    static class Guard {
        private int ACCESS_ALLOWED = 1;

        private boolean allow() {
            return 42 == ACCESS_ALLOWED;
        }

        public void work() {
            if (allow()) {
                System.out.println("I am working by allowed");
            }
        }

    }

    static class Simple {
        private long l = 0;

        public Simple() {
            this.l = 1;
            System.out.println("=========");
        }

        public long get() {
            return this.l;
        }
    }

}
