package com.dove.lol.dovelol.demo.date201809.demo20180916;

import java.util.Objects;

/**
 * @author Dovelol
 * @date 2018/9/16 9:04
 */
public class HashCodeSample {


    public static void main(String[] args) {

        String str1 = "ok";

        String str2 = new String("ok");

        System.out.println(str1.hashCode());
        System.out.println(Objects.hashCode(str1));
        System.out.println(Objects.hash(str2));

        System.out.println(str1.getClass());
    }

}
