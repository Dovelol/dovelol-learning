package com.dove.lol.dovelol.demo.date201801.demo20180116;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dovelol
 * @date 2018/1/16 22:19
 */
public class ReadWriteLockExample1 {

    private static final ReentrantLock LOCK = new ReentrantLock();

    private static final List<Long> DATA = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(ReadWriteLockExample1::write);
        thread1.start();

        TimeUnit.SECONDS.sleep(1);

        Thread thread2 = new Thread(ReadWriteLockExample1::read);
        thread2.start();

    }

    private static void write() {
        try {
            LOCK.lock();
            DATA.add(System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    private static void read() {
        try {
            LOCK.lock();
            DATA.forEach(System.out::println);
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName() + "=================");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

}
