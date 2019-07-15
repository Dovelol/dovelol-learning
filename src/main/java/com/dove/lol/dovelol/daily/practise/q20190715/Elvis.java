package com.dove.lol.dovelol.daily.practise.q20190715;

import java.util.Calendar;

/**
 * @author Dovelol
 * @date 2019/7/15 21:15
 */
public class Elvis {

    /**
     * 以上程序输出内容是？
     *
     *  (a) Elvis wears size 0 belt.
     *  (b) Elvis wears size 73 belt.
     *  (c) Elvis wears size -1930 belt.
     *  (d) 以上答案都不对
     */


    public static final Elvis INSTANCE = new Elvis();
    private final int beltSize;

    private static final int CURRENT_YEAR =
            Calendar.getInstance().get(Calendar.YEAR);


    private Elvis() {
        beltSize = CURRENT_YEAR - 1930;
    }

    public int beltSize() {
        return beltSize;
    }

    public static void main(String[] args) {
        System.out.println("Elvis wears size " +
                INSTANCE.beltSize() + " belt.");
    }


}
