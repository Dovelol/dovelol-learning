package com.dove.lol.dovelol.demo.thread.date201712.demo20171204;

/**
 * @author Dovelol
 */
public class DeadLock {

    private OtherService otherService;

    private final Object LOCK = new Object();

    public DeadLock(OtherService otherService) {
        this.otherService = otherService;
    }

    public void d1() {
        synchronized (LOCK) {
            System.out.println("d1==========");
            otherService.o1();
        }
    }

    public void d2() {
        synchronized (LOCK) {
            System.out.println("d2==========");
        }
    }

}
