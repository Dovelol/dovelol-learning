package com.dove.lol.dovelol.demo.date201809.demo20180916;

import java.util.Comparator;

/**
 * @author Dovelol
 * @date 2018/9/16 21:54
 */
public class LambdaSample {

    public static void main(String[] args) {
        Comparator<String> stringComparator = (String first, String second) -> first.length() - second.length();
    }

}
