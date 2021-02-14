package com.dove.lol.dovelol.demo.date202011.demo20201128;

import java.nio.ByteBuffer;

/**
 * @author Dovelol
 * @date 2020/11/28 15:48
 */
public class NioDemo {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for(int i =0;i < 10; i ++){
            byteBuffer.put((byte)i);
        }
    }

}
