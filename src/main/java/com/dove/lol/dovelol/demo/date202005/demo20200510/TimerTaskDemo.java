package com.dove.lol.dovelol.demo.date202005.demo20200510;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Dovelol
 * @date 2020/5/10 0:32
 */
public class TimerTaskDemo extends TimerTask {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer("ScheduleMessageTimerThread", true);
        timer.schedule(new TimerTaskDemo(),1000L,1000L);

        Thread.sleep(1000000000);

    }


    @Override
    public void run() {
        System.out.println(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date()));
    }
}
