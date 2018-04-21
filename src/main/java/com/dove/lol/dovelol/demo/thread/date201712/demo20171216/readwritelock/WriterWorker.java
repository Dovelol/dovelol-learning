package com.dove.lol.dovelol.demo.thread.date201712.demo20171216.readwritelock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/16 18:46
 */
public class WriterWorker extends Thread {

    private static final Random random = new Random(System.currentTimeMillis());

    private final ShareData data;

    private final String filler;

    private int index;

    public WriterWorker(ShareData data, String filler) {
        this.data = data;
        this.filler = filler;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char c = nextChar();
                data.write(c);
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar() {
        char c = filler.charAt(index);
        index++;
        if (index >= filler.length()) {
            index = 0;
        }
        return c;

    }


}
