package com.dove.lol.dovelol.nio.netty.demo1;

/**
 * @author Dovelol
 * @date 2018/12/15 22:58
 */
public class ServerBoot {

    private static final int PORT = 8848;

    public static void main(String[] args) {
        Server server = new Server(PORT);
        server.start();
    }


}
