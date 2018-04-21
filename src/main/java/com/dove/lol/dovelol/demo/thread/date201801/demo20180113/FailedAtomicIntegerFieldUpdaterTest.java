package com.dove.lol.dovelol.demo.thread.date201801.demo20180113;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author Dovelol
 * @date 2018/1/13 18:37
 */
public class FailedAtomicIntegerFieldUpdaterTest {

    @Test
    public void test() {
        AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterTest.TestMe> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterTest.TestMe.class, "i");

        AtomicIntegerFieldUpdaterTest.TestMe testMe = new AtomicIntegerFieldUpdaterTest.TestMe();

        updater.compareAndSet(testMe, 0, 1);

    }

    public static void main(String[] args) {
        try {
            AtomicIntegerFieldUpdaterTest.TestMe testMe = new AtomicIntegerFieldUpdaterTest.TestMe();
            Field field = testMe.getClass().getDeclaredField("i");
            System.out.println(field.getModifiers());
            System.out.println(field.getModifiers() &  0x00000040);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
