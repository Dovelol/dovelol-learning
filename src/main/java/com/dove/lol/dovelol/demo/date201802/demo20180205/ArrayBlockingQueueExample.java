package com.dove.lol.dovelol.demo.date201802.demo20180205;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author Dovelol
 * @date 2018/2/5 22:48
 */
public class ArrayBlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        //testAddMethod();
        //testOfferMethod();
        //testPutMethod();
        //testPoll();
        //testPeek();
        //testElement();
        //testRemove();
        testdrainTo();
    }


    public <T> ArrayBlockingQueue<T> create(int size) {
        return new ArrayBlockingQueue<T>(size);
    }


    public static void testAddMethod() {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue(5);
        System.out.println(queue.add("Hello1"));
        System.out.println(queue.add("Hello2"));
        System.out.println(queue.add("Hello3"));
        System.out.println(queue.add("Hello4"));
        System.out.println(queue.add("Hello5"));
        System.out.println(queue.add("Hello6"));
    }


    public static void testOfferMethod() {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue(5);
        System.out.println(queue.offer("Hello1"));
        System.out.println(queue.offer("Hello2"));
        System.out.println(queue.offer("Hello3"));
        System.out.println(queue.offer("Hello4"));
        System.out.println(queue.offer("Hello5"));
        System.out.println(queue.offer("Hello6"));
    }

    public static void testPutMethod() throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue(5);
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(() -> {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, TimeUnit.SECONDS);

        queue.put("Hello1");
        queue.put("Hello2");
        queue.put("Hello3");
        queue.put("Hello4");
        queue.put("Hello5");
        queue.put("Hello6");
        TimeUnit.SECONDS.sleep(1);
        executorService.shutdown();
    }

    public static void testPoll() {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue(5);
        queue.add("Hello1");
        queue.add("Hello2");
        queue.add("Hello3");
        queue.add("Hello4");
        queue.add("Hello5");
        System.out.println(queue.poll());
        queue.add("Hello6");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    public static void testPeek() {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue(5);
        queue.add("Hello1");
        queue.add("Hello2");
        queue.add("Hello3");
        queue.add("Hello4");
        queue.add("Hello5");
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
    }



    public static void testElement() {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue(5);
        queue.add("Hello1");
        queue.add("Hello2");
        queue.add("Hello3");
        queue.add("Hello4");
        queue.add("Hello5");
        queue.clear();
        System.out.println(queue.element());
        System.out.println(queue.element());
        System.out.println(queue.element());
        System.out.println(queue.element());
        System.out.println(queue.element());
        System.out.println(queue.element());
        System.out.println(queue.element());
    }


    public static void testRemove() {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue(5);
        queue.add("Hello1");
        queue.add("Hello2");
        queue.add("Hello3");
        queue.add("Hello4");
        queue.add("Hello5");
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

    }


    public static void testdrainTo() {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue(5);
        queue.add("Hello1");
        queue.add("Hello2");
        queue.add("Hello3");
        queue.add("Hello4");
        queue.add("Hello5");
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println(queue.drainTo(arrayList));
        System.out.println(arrayList);
        System.out.println(queue.size());
    }
}
