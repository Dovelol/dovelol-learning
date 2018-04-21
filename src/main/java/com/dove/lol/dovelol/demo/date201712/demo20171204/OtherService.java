package com.dove.lol.dovelol.demo.date201712.demo20171204;

/**
 * @author Dovelol
 */
public class OtherService {

    private final Object LOCK = new Object();

    private DeadLock deadLock;

    public void o1() {
        synchronized (LOCK) {

            System.out.println("o1==========");
        }
    }

    public void o2() {
        synchronized (LOCK) {
            System.out.println("o2==========");
            deadLock.d2();
        }
    }

    public DeadLock getDeadLock() {
        return deadLock;
    }

    public void setDeadLock(DeadLock deadLock) {
        this.deadLock = deadLock;
    }
}
