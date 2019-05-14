package com.dove.lol.dovelol.demo.date201904.demo20190407;

/**
 * @author Dovelol
 * @date 2019/4/7 21:18
 */
public class ThreadDemo {


    public static void main(String[] args) {
//        Thread t1 = new Thread(ThreadDemo::action, "t1");
//        Thread t2 = new Thread(ThreadDemo::action, "t2");
//        Thread t3 = new Thread(ThreadDemo::action, "t3");
//
//        startAndWait(t1);
//        startAndWait(t2);
//        startAndWait(t3);


        Thread thread = new Thread(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        Object object = new Object();
        synchronized (thread) {
            try {
                thread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("结束");

    }

    public static void startAndWait(Thread thread) {
        if (Thread.State.NEW.equals(thread.getState())) {
            thread.start();
        }
        Object object = new Object();
        synchronized (thread) {
            try {
                thread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void action() {
        System.out.println("当前线程：" + Thread.currentThread().getName());
    }

}
