package com.dove.lol.dovelol.demo.date201712.demo20171219;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/19 22:11
 */
public class CustomerThread extends Thread {

    private final BalkingData balkingData;

    private final Random random = new Random(System.currentTimeMillis());

    public CustomerThread(BalkingData balkingData) {
        super("Customer");
        this.balkingData = balkingData;
    }

    @Override
    public void run() {
        balkingData.save();
        for (int i = 0; i < 20; i++) {
            balkingData.change("No." + i);
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balkingData.save();
        }
        super.run();
    }
}
