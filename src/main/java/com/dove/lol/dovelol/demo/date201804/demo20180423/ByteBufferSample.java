package com.dove.lol.dovelol.demo.date201804.demo20180423;


import java.nio.ByteBuffer;

/**
 * @author Dovelol
 * @date 2018/4/23 22:12
 */
public class ByteBufferSample {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(7);
        String str = "dovelol";

        byteBuffer.put(str.getBytes());

        byteBuffer.flip();

        System.out.println(byteBuffer.remaining());

        byte[] vArray = new byte[byteBuffer.remaining()];

        System.out.println(byteBuffer.get(10));

        System.out.println(byteBuffer.remaining());
        System.out.println(new String(vArray));


    }

}
