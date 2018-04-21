package com.dove.lol.dovelol.demo.date201712.demo20171216.readwritelock;

/**
 * @author Dovelol
 * @date 2017/12/16 18:59
 */
public class ReadWriteLockClient {

    public static void main(String[] args) {
        final ShareData shareData = new ShareData(10);
        new ReaderWorker(shareData).start();
        new ReaderWorker(shareData).start();
        new ReaderWorker(shareData).start();
        new ReaderWorker(shareData).start();
        new ReaderWorker(shareData).start();
        new WriterWorker(shareData, "yuanzheng").start();
        new WriterWorker(shareData, "YUANZHENG").start();
    }
}
