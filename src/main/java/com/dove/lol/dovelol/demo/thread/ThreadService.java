package com.dove.lol.dovelol.demo.thread;

import java.util.concurrent.TimeUnit;

public class ThreadService {

    private Thread executeThread;

    private boolean finished = false;

    public void execute(Runnable task) {

        executeThread = new Thread() {
            @Override
            public void run() {
                Thread runner = new Thread(task);
                runner.setDaemon(true);
                runner.start();

                try {
                    runner.join();
                    finished = true;
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }


            }
        };
        executeThread.setDaemon(true);
        executeThread.start();
    }

    public void shutdown(long mills) {
        long startTime = System.currentTimeMillis();
        while (!finished) {
            if ((System.currentTimeMillis() - startTime) >= mills) {
                System.out.println("任务超时，需要结束！");
                executeThread.interrupt();
                break;
            }
            try {
                executeThread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(executeThread.isInterrupted());
                System.out.println("执行线程被打断！");
                break;
            }

        }
        finished = false;
    }

}
