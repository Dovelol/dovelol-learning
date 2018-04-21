package com.dove.lol.dovelol.demo.thread.date201712.demo20171220;

/**
 * @author Dovelol
 * @date 2017/12/20 22:35
 */
public class CountDown {

    private final int total;

    private int counter = 0;

    public CountDown(int total) {
        this.total = total;
    }


    public void down() {
        synchronized (this) {
            this.counter++;
            this.notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (this) {
            while (counter != total) {
                this.wait();
            }
        }
    }
}
