package com.dove.lol.dovelol.demo.date201802.demo20180206;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;


import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class PriorityBlockingQueueExampleTest {

    private PriorityBlockingQueueExample example;

    @Before
    public void setUp() {
        example = new PriorityBlockingQueueExample();
    }

    @After
    public void tearDown() {
        example = null;
    }

    @Test
    public void testAddNewElement() {
        PriorityBlockingQueue<String> queue = example.create(5);

        assertThat(queue.add("hello1"), equalTo(true));
        assertThat(queue.add("hello2"), equalTo(true));
        assertThat(queue.add("hello3"), equalTo(true));
        assertThat(queue.add("hello4"), equalTo(true));
        assertThat(queue.add("hello5"), equalTo(true));
        assertThat(queue.add("hello6"), equalTo(true));
        assertThat(queue.size(), equalTo(6));
    }

    @Test
    public void testGetNewElement() {
        PriorityBlockingQueue<String> queue = example.create(5);
        assertThat(queue.add("hello4"), equalTo(true));
        assertThat(queue.add("hello2"), equalTo(true));
        assertThat(queue.add("hello3"), equalTo(true));
        assertThat(queue.element(), equalTo("hello2"));
        assertThat(queue.size(), equalTo(3));
        assertThat(queue.element(), equalTo("hello2"));
        assertThat(queue.size(), equalTo(3));


        assertThat(queue.peek(), equalTo("hello2"));
        assertThat(queue.size(), equalTo(3));
        assertThat(queue.peek(), equalTo("hello2"));
        assertThat(queue.size(), equalTo(3));

        assertThat(queue.poll(), equalTo("hello2"));
        assertThat(queue.size(), equalTo(2));
        assertThat(queue.poll(), equalTo("hello3"));
        assertThat(queue.size(), equalTo(1));


        assertThat(queue.remove("hello4"), equalTo(true));
        assertThat(queue.size(), equalTo(0));
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullElement() {
        PriorityBlockingQueue<String> queue = example.create(5);
        queue.add(null);
    }

    @Test(expected = ClassCastException.class)
    public void testAddObjectWithNoComparable() {
        PriorityBlockingQueue<UserWithNoComparable> queue = example.create(5);
        queue.add(new UserWithNoComparable());
        fail("should not process to here");
    }

    @Test
    public void testAddObjectWithComparable() {
        PriorityBlockingQueue<UserWithNoComparable> queue = example.create(3, Comparator.comparingInt(Object::hashCode));
        queue.add(new UserWithNoComparable());
    }

    @Test
    public void testAddObjectWithComparable2() {
        PriorityBlockingQueue<UserWithComparable> queue = example.create(3);
        queue.add(new UserWithComparable());
    }

    static class UserWithNoComparable {

    }

    static class UserWithComparable implements Comparable<UserWithComparable> {

        @Override
        public int compareTo(UserWithComparable o) {
            return 0;
        }
    }
}