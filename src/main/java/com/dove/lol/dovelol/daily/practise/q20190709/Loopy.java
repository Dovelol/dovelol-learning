package com.dove.lol.dovelol.daily.practise.q20190709;

/**
 * @author Dovelol
 * @date 2019/7/11 22:48
 */
public class Loopy {


    /**
     *  以上程序输出内容是？
     *
     *  (handler) 100
     *  (b) 101
     *  (c) 以上都不是
     *  (d) 99
     */

    public static void main(String[] args) {
        final int start = Integer.MAX_VALUE - 100;
        final int end = Integer.MAX_VALUE;
        int count = 0;
        for (int i = start; i <= end; i++) {
            count++;
        }
        System.out.println(count);
    }
}
