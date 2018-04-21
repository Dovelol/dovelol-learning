package com.dove.lol.dovelol.demo.date201712.demo20171219;

import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/19 22:14
 */
public class WaiterThread extends Thread {

    private final BalkingData balkingData;


    public WaiterThread(BalkingData balkingData) {
        super("Waiter");
        this.balkingData = balkingData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            balkingData.save();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
