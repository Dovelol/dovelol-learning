package com.dove.lol.dovelol.demo.date201903.demo20190314;

import java.util.LinkedList;

public class ProducerConsumerDemo {

    private final LinkedList<Integer> list;

    private final int size;

    public ProducerConsumerDemo(LinkedList<Integer> list, int size) {
        this.list = list;
        this.size = size;
    }

    public static void main(String[] args) {
        final LinkedList<Integer> list = new LinkedList<>();
        ProducerConsumerDemo demo = new ProducerConsumerDemo(list, 100);
        new Thread(() -> {
            demo.producer();
        }, "producer").start();


        new Thread(() -> {
            while (true) {
                demo.consumer();
            }
        }, "consumer").start();
    }


    public void producer() {
        int i = 0;
        while (true) {
            synchronized (list) {
                while (list.size() == size) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "->: list is full.");
                        list.wait();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "->: " + i);
                list.addLast(i);
                list.notifyAll();
                i++;
            }
        }
    }


    public void consumer() {
        while (true) {
            synchronized (list) {
                while (list.size() == 0) {
                    try {

                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "->: " + list.removeFirst());
                list.notifyAll();

            }
        }

    }

}
