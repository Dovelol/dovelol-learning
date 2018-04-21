package com.dove.lol.dovelol.demo.thread.date201712.demo20171216.readwritelock;

/**
 * @author Dovelol
 * @date 2017/12/16 18:54
 */
public class ReaderWorker extends Thread {

    private final ShareData data;

    public ReaderWorker(ShareData data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char[] readBuf = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readBuf));
            }
        } catch (Exception e) {

        }
    }
}
