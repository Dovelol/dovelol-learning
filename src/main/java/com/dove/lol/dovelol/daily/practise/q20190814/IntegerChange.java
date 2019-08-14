package com.dove.lol.dovelol.daily.practise.q20190814;

import java.lang.reflect.Field;

/**
 * @author Dovelol
 * @date 2019/8/14 23:21
 */
public class IntegerChange {


    /**
     *  以上程序输出内容是？

     *  (a) 100 200 300
     *  (b) 300 300 300
     *  (c) 100 300 300
     *  (d) 以上答案都不是
     */
    public static void main(String[] args) throws Exception {
        Integer a = Integer.parseInt("10");
        Integer b = Integer.valueOf(10);
        Integer c = 10;
        changeValue(a, 100);
        changeValue(b, 200);
        changeValue(c, 300);
        System.out.printf("%d %d %d", a, b, c);
    }

    private static void changeValue(Integer i, int value) throws Exception {
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        field.set(i, value);
    }

}
