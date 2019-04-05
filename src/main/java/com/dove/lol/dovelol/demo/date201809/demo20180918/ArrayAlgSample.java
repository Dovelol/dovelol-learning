package com.dove.lol.dovelol.demo.date201809.demo20180918;

import java.io.Serializable;

/**
 * @author Dovelol
 * @date 2018/9/18 23:05
 */
public class ArrayAlgSample {

    public static void main(String[] args) {
        Serializable middle = ArrayAlgSample.getMiddle(3.14, 1729, 0, "abc");
        System.out.println(middle);
    }

    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

}
