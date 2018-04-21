package com.dove.lol.dovelol.demo.date201801.demo20180122;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.Collectors;

/**
 * @author Dovelol
 * @date 2018/1/22 21:54
 */
public class StampedLockExample1 {

    private static final StampedLock LOCK = new StampedLock();

    private static final List<Long> DATA = new ArrayList<>();

    /**
     * ReentrantLock VS Synchronized
     *
     * @param args
     */
    public static void main(String[] args) {
        final ExecutorService service = Executors.newFixedThreadPool(10);

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    read();
                }
            }
        };


        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    write();
                }
            }
        };

        service.submit(readTask);
        service.submit(readTask);
        service.submit(readTask);
        service.submit(readTask);
        service.submit(readTask);
        service.submit(readTask);
        service.submit(readTask);
        service.submit(readTask);
        service.submit(readTask);
        service.submit(writeTask);

    }

    private static void read() {
        long stamped = -1;
        try {
            stamped = LOCK.readLock();
            Optional.of(DATA.stream().map(String::valueOf).collect(Collectors.joining("#", "R-", ""))).ifPresent(System.out::println);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlockRead(stamped);
        }
    }

    private static void write() {
        long stamp = -1;
        try {
            stamp = LOCK.writeLock();
            DATA.add(System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlockWrite(stamp);
        }

    }


}
