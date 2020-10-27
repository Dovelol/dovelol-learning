package com.dove.lol.dovelol.demo.date202010.demo20201017;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author Dovelol
 * @date 2020/10/17 0:48
 */
public class UTF8 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        char c = '\u4e2d';
        System.out.println(c+"0");
        System.out.println(Integer.toString(c));

        String str = "中";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));

        System.out.println(Integer.toHexString(c));
        System.out.println(Integer.toBinaryString(-28));
        System.out.println(Integer.toHexString(-72));
        System.out.println(Integer.toHexString(72));
        System.out.println(Integer.toHexString(-83));

        System.out.println(Hex.encodeHexString(bytes));

    }

}
