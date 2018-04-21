package com.dove.lol.dovelol.demo.thread.date201712.demo20171226;

import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/26 21:36
 */
public class SimpleEncrypt {

    private static final String PLAIN = "Hello ClassLoader";

    private static final byte ENCRYPT_FACTOR = (byte) 0xff;


    public static void main(String[] args) {
        byte[] bytes = PLAIN.getBytes();

        byte[] encrypt = new byte[bytes.length];

        for (int i = 0; i < bytes.length; i++){
            encrypt[i] = (byte) (bytes[i] ^ ENCRYPT_FACTOR);
        }

        System.out.println(new String(encrypt));

        byte[] encrypt1 = new byte[2024_000_000];

        try {
            TimeUnit.SECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
