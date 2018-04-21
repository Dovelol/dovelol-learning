package com.dove.lol.dovelol.demo.thread.date201803.demo20180303;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class SynchronousQueueExanpleTest {


    @Test
    public void testAdd() {
        SynchronousQueue<String> queue = SynchronousQueueExample.create();

        Executors.newSingleThreadExecutor().execute(()->{
            try {
                assertThat(queue.take(), equalTo("hello"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        try {
            TimeUnit.MILLISECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(queue.add("hello"), equalTo(true));

    }


    @Test
    public void testPut() {
        SynchronousQueue<String> queue = SynchronousQueueExample.create();

        try {
            queue.put("hello");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}