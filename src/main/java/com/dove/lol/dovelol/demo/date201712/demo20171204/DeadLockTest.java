package com.dove.lol.dovelol.demo.date201712.demo20171204;

/**
 * @author Dovelol
 */
public class DeadLockTest {

    public static void main(String[] args) {
        OtherService otherService = new OtherService();
        DeadLock deadLock = new DeadLock(otherService);
        otherService.setDeadLock(deadLock);

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    deadLock.d1();
                }
            }
        }.start();


        new Thread(){
            @Override
            public void run() {
                while (true){
                    otherService.o2();
                }
            }
        }.start();
    }

}
