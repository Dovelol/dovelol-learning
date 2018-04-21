package com.dove.lol.dovelol.demo;

import java.util.concurrent.TimeUnit;

public class ThreadCloseGraceful {

    private static class Worker extends Thread {

        private volatile boolean start = true;

        @Override
        public void run() {
            while (start) {
                //
            }
        }

        public void shutdown() {
            this.start = false;
        }
    }


    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("sleep done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       // worker.shutdown();

    }

}
