package com.dove.lol.dovelol.demo.thread.date201712.demo20171217;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/17 19:21
 */
public class ThreadLocalSimulatorTest {

    private static final ThreadLocalSimulator<String> threadlocal = new ThreadLocalSimulator<String>(){
        @Override
        public String initValue() {
            return "main";
        }
    };

    private static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            threadlocal.set("Thread-t1");
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
                System.out.println(Thread.currentThread().getName() + " " + threadlocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            threadlocal.set("Thread-t2");
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
                System.out.println(Thread.currentThread().getName() + " " + threadlocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " " + threadlocal.get());

    }
}
