package com.dove.lol.dovelol.demo.date201801.demo20180128;

import javafx.concurrent.Task;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/1/28 18:43
 */
public class TimerScheduler {

    /**
     * scheduler solution
     * <p>
     * Timer/TimerTask
     * <p>
     * SchedulerExecutorService
     * <p>
     * crontab
     * cron4j
     * <p>
     * quartz
     *
     * @param args
     */
    public static void main(String[] args) {
        Timer timer = new Timer();

        final TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("======" + System.currentTimeMillis());

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        timer.schedule(timerTask,1000,2000);
    }

}
