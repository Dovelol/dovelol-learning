package com.dove.lol.dovelol.demo.date201801.demo20180111;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Dovelol
 * @date 2018/1/11 22:41
 */
public class AtomicBooleanTest {

    @Test
    public void testCreate() {
        AtomicBoolean bool = new AtomicBoolean();
        Assertions.assertFalse(bool.get());
    }

    @Test
    public void testCreate2() {
        AtomicBoolean bool = new AtomicBoolean(true);
        Assertions.assertTrue(bool.get());
    }

    @Test
    public void testGetAndSet() {
        AtomicBoolean bool = new AtomicBoolean(true);
        boolean resulte = bool.getAndSet(false);
        Assertions.assertTrue(resulte);
        Assertions.assertFalse(bool.get());
    }

    @Test
    public void testCompareAndSet() {
        AtomicBoolean bool = new AtomicBoolean(true);
        boolean resulte = bool.compareAndSet(true, true);
        Assertions.assertTrue(resulte);
        Assertions.assertFalse(bool.get());
    }

}
