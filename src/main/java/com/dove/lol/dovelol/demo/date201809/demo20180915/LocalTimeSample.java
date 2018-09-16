package com.dove.lol.dovelol.demo.date201809.demo20180915;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Dovelol
 * @date 2018/9/15 9:05
 */
public class LocalTimeSample {

    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalDate date = LocalDate.now();
        System.out.println(date);
    }

}
