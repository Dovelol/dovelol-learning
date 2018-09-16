package com.dove.lol.dovelol.demo.date201809.demo20180912;

import java.util.Arrays;

/**
 * @author Dovelol
 * @date 2018/9/12 22:15
 */
public class StringSample {

    public static void main(String[] args) {
        String str = "aovelol";
        System.out.println(str.codePointAt(0));
        int[] ints = str.codePoints().toArray();
        System.out.println(Arrays.toString(ints));

        System.out.println(0b111);

        System.out.println(str.substring(1, 2));

        switch (new String("1")) {
            default:
        }
    }

}
