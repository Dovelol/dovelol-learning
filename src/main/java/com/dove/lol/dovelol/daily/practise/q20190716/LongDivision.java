package com.dove.lol.dovelol.daily.practise.q20190716;

/**
 * @author Dovelol
 * @date 2019/7/16 21:23
 */
public class LongDivision {

    /**
     * 以上程序输出内容是？

     *  (handler) 5
     *  (b) 1000
     *  (c) 抛出异常
     *  (d) 以上答案都不对
     */


    private static final long MILLIS_PER_DAY
            = 24 * 60 * 60 * 1000;

    private static final long MICROS_PER_DAY
            = 24 * 60 * 60 * 1000 * 1000;

    public static void main(String[] args) {
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
    }

}
