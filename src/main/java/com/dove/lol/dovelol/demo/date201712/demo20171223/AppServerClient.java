package com.dove.lol.dovelol.demo.date201712.demo20171223;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/23 9:35
 */
public class AppServerClient {
    public static void main(String[] args) {
        AppServer appServer = new AppServer(12345);
        appServer.start();
        try {
            TimeUnit.SECONDS.sleep(60);
            appServer.shutdown();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
