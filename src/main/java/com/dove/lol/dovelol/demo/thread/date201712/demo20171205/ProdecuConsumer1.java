package com.dove.lol.dovelol.demo.thread.date201712.demo20171205;

/**
 * @author Dovelol
 * @date 2017/12/5
 */
public class ProdecuConsumer1 {

    private int index = 1;

    private final Object LOCK = new Object();

    private void produce() {
        synchronized (LOCK) {
            System.out.println("produce:" + (index++));
        }

    }


    private void consumer() {
        synchronized (LOCK) {
            System.out.println("consumer:" + (index));
        }

    }

    public static void main(String[] args) {

        ProdecuConsumer1 prodecuConsumer1 = new ProdecuConsumer1();

        new Thread("P") {
            @Override
            public void run() {
                while (true) {
                    prodecuConsumer1.produce();
                }
            }
        }.start();


        new Thread("C") {
            @Override
            public void run() {
                while (true) {
                    prodecuConsumer1.consumer();
                }
            }
        }.start();
    }


}
