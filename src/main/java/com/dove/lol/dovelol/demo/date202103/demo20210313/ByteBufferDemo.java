package com.dove.lol.dovelol.demo.date202103.demo20210313;

import java.nio.ByteBuffer;

/**
 * @author Dovelol
 * @date 2021/3/13 14:46
 */
public class ByteBufferDemo {


    public static void main(String[] args) {
        ByteBuffer buffer =ByteBuffer.allocate(1024);
        byte b = buffer.get(10);
        System.out.println(b);
        buffer.putInt(10);
        //System.out.println(buffer.remaining());
        buffer.flip();
        System.out.println(buffer.remaining());
        System.out.println(buffer.getInt());
    }
}
