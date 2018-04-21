package com.dove.lol.dovelol.demo.date201802.demo20180207;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.LinkedBlockingQueue;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class LinkedBlockingQueueExampleTest {

    private LinkedBlockingQueueExample example;

    @Before
    public void getUp() {
        example = new LinkedBlockingQueueExample();
    }

    @After
    public void tearDown() {
        example = null;
    }

    @Test
    public void testInsertData() throws InterruptedException {
        LinkedBlockingQueue<String> queue = example.create(3);
        assertThat(queue.add("data1"), equalTo(true));
        assertThat(queue.add("data2"), equalTo(true));
        assertThat(queue.add("data3"), equalTo(true));

        queue.clear();
        assertThat(queue.offer("data2"), equalTo(true));
        assertThat(queue.offer("data1"), equalTo(true));
        assertThat(queue.offer("data3"), equalTo(true));

        assertThat(queue.element(), equalTo("data2"));
        assertThat(queue.poll(), equalTo("data2"));
        assertThat(queue.poll(), equalTo("data1"));
        assertThat(queue.poll(), equalTo("data3"));
        assertThat(queue.size(), equalTo(0));


    }

}