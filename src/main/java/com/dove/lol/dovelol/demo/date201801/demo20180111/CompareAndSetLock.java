package com.dove.lol.dovelol.demo.date201801.demo20180111;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dovelol
 * @date 2018/1/11 22:19
 */
public class CompareAndSetLock {

    private final AtomicInteger value = new AtomicInteger(0);

    private Thread lockedThread;

    public void tryLock() throws GetLockException {
        boolean success = value.compareAndSet(0, 1);
        if (!success) {
            throw new GetLockException("Get the Lock failed.");
        } else {
            lockedThread = Thread.currentThread();
        }
    }


    public void unlock() {
        if (0 == value.get()) {
            return;
        }
        if (Objects.equals(lockedThread, Thread.currentThread())) {
            value.compareAndSet(1, 0);
        }
    }

}
