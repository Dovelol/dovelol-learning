package com.dove.lol.dovelol.demo.date201712.demo20171223;

import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2017/12/23 8:10
 */
public class PerThreadClient {

    public static void main(String[] args) {
        final MessageHandler messageHandler = new MessageHandler();
        IntStream.rangeClosed(0, 10).forEach(i -> {
            messageHandler.request(new Message(String.valueOf(i)));
        });
        messageHandler.shutdown();
    }

}
