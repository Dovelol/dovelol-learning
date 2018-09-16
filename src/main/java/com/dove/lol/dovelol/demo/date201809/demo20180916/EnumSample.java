package com.dove.lol.dovelol.demo.date201809.demo20180916;

import java.util.Arrays;

import static com.dove.lol.dovelol.demo.date201809.demo20180916.SizeEnum.MEDIUM;

/**
 * @author Dovelol
 * @date 2018/9/16 10:15
 */
public class EnumSample {

    public static void main(String[] args) {
        System.out.println(SizeEnum.SMALL.toString());

        System.out.println(Enum.valueOf(SizeEnum.class, "LARGE").getAbbreviation());

        SizeEnum[] values = SizeEnum.values();
        System.out.println(Arrays.toString(values));


        System.out.println(MEDIUM.ordinal());
    }

}
