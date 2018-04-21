package com.dove.lol.dovelol.demo.date201804.demo20180418;

/**
 * @author Dovelol
 * @date 2018/4/18 23:16
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8080;
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();

    }

}
