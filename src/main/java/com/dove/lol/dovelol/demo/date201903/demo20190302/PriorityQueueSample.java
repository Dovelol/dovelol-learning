package com.dove.lol.dovelol.demo.date201903.demo20190302;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Dovelol
 * @date 2019/3/2 10:43
 */
public class PriorityQueueSample {


    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        queue.add(1);
        queue.add(3);

        queue.add(2);
        queue.add(55);
        queue.add(10);
        queue.add(15);
        queue.add(30);
        queue.add(20);
        queue.add(5);
        queue.add(9);
        queue.forEach(System.out::println);

        queue.iterator().forEachRemaining(System.out::println);

        for (Integer integer : queue){
            System.out.println(integer);
        }


        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
//
//        // Use add() method to add elements into the Queue
//        queue.add(10);
//        queue.add(15);
//        queue.add(30);
//        queue.add(20);
//        queue.add(5);
//
//               queue.forEach(System.out::println);
//
//        // Displaying the PriorityQueue
//        System.out.println("PriorityQueue: " + queue);
//
//        // Creating an iterator
//        Iterator value = queue.iterator();
//
//        // Displaying the values after iterating through the queue
//        System.out.println("The iterator values are: ");
//        while (value.hasNext()) {
//            System.out.println(value.next());
//        }

    }

}
