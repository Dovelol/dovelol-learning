package com.dove.lol.dovelol.demo.thread.date201712.demo20171205;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author Dovelol
 * @date 2017/12/5
 */
public class ProdecuConsumer2 {

    private int index = 0;

    private final Object LOCK = new Object();

    private boolean isProduced = false;

    private void produce() {
        synchronized (LOCK) {
            if (isProduced) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                index++;
                System.out.println("P->:" + (index));
                LOCK.notifyAll();
                isProduced = true;
            }
        }

    }


    private void consumer() {
        synchronized (LOCK) {
            if (isProduced) {
                System.out.println("C->:" + (index));
                LOCK.notifyAll();
                isProduced = false;
            } else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }

    }

    public static void main(String[] args) {

        ProdecuConsumer2 prodecuConsumer2 = new ProdecuConsumer2();
        Stream.of("P1", "P2", "P3", "P4").forEach(n -> {
            new Thread(n) {
                @Override
                public void run() {
                    while (true) {
                        prodecuConsumer2.produce();
                        try {
                            TimeUnit.MILLISECONDS.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        });
        Stream.of("C1", "C2", "C3", "C4").forEach(n -> {
            new Thread(n) {
                @Override
                public void run() {
                    while (true) {
                        prodecuConsumer2.consumer();
                        try {
                            TimeUnit.MILLISECONDS.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        });
    }

}
