package com.dove.lol.dovelol.demo.date201802.demo20180205;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Dovelol
 * @date 2018/2/5 22:55
 */
public class ArrayBlockingQueueExampleTest {

    private ArrayBlockingQueueExample example;

    @Before(value = "")
    public void setUp() {
        example = new ArrayBlockingQueueExample();
    }

    @After(value = "")
    public void after() {
        example = null;
    }

    @Test
    public void testAddMethod() {
        ArrayBlockingQueue<String> queue =  new ArrayBlockingQueueExample().create(5);
        Assert.isTrue(queue.add("Hello"));
        Assert.isTrue(queue.add("Hello"));
        Assert.isTrue(queue.add("Hello"));
        Assert.isTrue(queue.add("Hello"));
        Assert.isTrue(queue.add("Hello"));
        Assert.isTrue(queue.add("Hello"));


    }

}
