package com.dove.lol.dovelol.demo.date201801.demo20180113;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author Dovelol
 * @date 2018/1/13 13:30
 */
public class AtomicIntegerArrayTest {

    @Test
    public void testCreateAtomicIntegerArray() {
        AtomicIntegerArray array = new AtomicIntegerArray(10);
        Assertions.assertEquals(10, array.length());
    }

    @Test
    public void testGet() {
        AtomicIntegerArray array = new AtomicIntegerArray(10);
        Assertions.assertEquals(0, array.get(5));
    }

    @Test
    public void testSet() {
        AtomicIntegerArray array = new AtomicIntegerArray(10);
        array.set(5, 5);
        Assertions.assertEquals(5, array.get(5));
    }

    @Test
    public void testGetAndSet() {
        int[] originalArray = new int[10];
        originalArray[5] = 5;
        AtomicIntegerArray array = new AtomicIntegerArray(originalArray);
        int v = array.getAndSet(5, 6);
        Assertions.assertEquals(5, v);
        Assertions.assertEquals(6, array.get(5));
    }

}
