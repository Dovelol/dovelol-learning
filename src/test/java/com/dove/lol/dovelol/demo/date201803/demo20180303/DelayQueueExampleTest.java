package com.dove.lol.dovelol.demo.date201803.demo20180303;


import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class DelayQueueExampleTest {

    @Test
    public void testAdd() {
        DelayQueue<DelayElement<String>> queue = DelayQueueExample.create();
        DelayElement<String> delayed1 = DelayElement.of("Delayed1", 1000);
        queue.add(delayed1);

        assertThat(queue.size(), equalTo(1));
        long startTime = System.currentTimeMillis();
//        try {
//            assertThat(queue.take(), is(delayed1));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //System.out.println(queue.peek().getData());
        try {
            System.out.println(queue.take().getData());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - startTime);

    }

    @Test
    public void testAdd2() {
        DelayQueue<DelayElement<String>> queue = DelayQueueExample.create();
        queue.add(DelayElement.of("Delayed1", 1000));
        queue.add(DelayElement.of("Delayed2", 800));
        queue.add(DelayElement.of("Delayed3", 11000));
        queue.add(DelayElement.of("Delayed4", 20000));
        assertThat(queue.size(), equalTo(4));
        long startTime = System.currentTimeMillis();
        Iterator<DelayElement<String>> iterator = queue.iterator();
        while (iterator.hasNext()) {
            assertThat(iterator.next(), notNullValue());
        }

        System.out.println(System.currentTimeMillis() - startTime);
        assertThat((System.currentTimeMillis() - startTime) < 5, equalTo(true));
    }

    @Test
    public void testAdd3() {
        DelayQueue<DelayElement<String>> queue = DelayQueueExample.create();
        queue.add(DelayElement.of("Delayed1", 1000));
        queue.add(DelayElement.of("Delayed2", 800));
        queue.add(DelayElement.of("Delayed3", 11000));
        queue.add(DelayElement.of("Delayed4", 20000));

        assertThat(queue.size(), equalTo(4));
        try {
            System.out.println(queue.take().getData());
            System.out.println(queue.take().getData());
            System.out.println(queue.take().getData());
            System.out.println(queue.take().getData());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test(expected = NoSuchElementException.class)
    public void testAdd4() {
        DelayQueue<DelayElement<String>> queue = DelayQueueExample.create();
        queue.add(DelayElement.of("Delayed1", 1000));
        queue.add(DelayElement.of("Delayed2", 800));
        queue.add(DelayElement.of("Delayed3", 11000));
        queue.add(DelayElement.of("Delayed4", 20000));
//        try {
//            TimeUnit.MILLISECONDS.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        assertThat(queue.size(), equalTo(4));
        assertThat(queue.remove().getData(), equalTo("Delayed3"));

    }

    @Test
    public void testAdd5() {
        DelayQueue<DelayElement<String>> queue = DelayQueueExample.create();
        queue.add(DelayElement.of("Delayed1", 100));
        queue.add(DelayElement.of("Delayed2", 80));
        queue.add(DelayElement.of("Delayed3", 1100));
        queue.add(DelayElement.of("Delayed4", 2000));

        try {
            TimeUnit.MILLISECONDS.sleep(85);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        try {
//            TimeUnit.MILLISECONDS.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        assertThat(queue.size(), equalTo(4));
        assertThat(queue.poll().getData(), equalTo("Delayed2"));

    }

    @Test()
    public void testAdd6() {
        DelayQueue<DelayElement<String>> queue = DelayQueueExample.create();
        try {
            queue.add(null);
            fail("=-==");
        } catch (NullPointerException e) {
            assertThat(e, isA(NullPointerException.class));
        }

    }

    static class DelayElement<E> implements Delayed {

        private final E e;

        private final long expireTime;

        public DelayElement(E e, long expireTime) {
            this.e = e;
            this.expireTime = System.currentTimeMillis() + expireTime;
        }

        static <T> DelayElement<T> of(T t, long delay) {
            return new DelayElement<>(t, delay);
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long diff = expireTime - System.currentTimeMillis();
            return unit.convert(diff, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed delayed) {
            DelayElement that = (DelayElement) delayed;
            if (this.expireTime < that.getExpireTime()) {
                return -1;
            } else if (this.expireTime > that.getExpireTime()) {
                return 1;
            }
            return 0;
        }

        public E getData() {
            return e;
        }

        public long getExpireTime() {
            return expireTime;
        }

    }

}