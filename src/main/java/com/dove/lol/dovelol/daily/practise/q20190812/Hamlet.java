package com.dove.lol.dovelol.daily.practise.q20190812;

import java.util.Random;

/**
 * @author Dovelol
 * @date 2019/8/12 23:12
 */
public class Hamlet {

    /**
     *  以上程序输出内容是？
     *  (handler)运行时异常
     *  (b)3
     *  (c)1.0
     *  (d)以上答案都不是
     *
     *  D
     */

    public static void main(String[] args) {

        Random rnd  = new Random();

        boolean toBe = rnd.nextBoolean();

        Number result = (toBe || !toBe)?new Integer(3):new Float(1);

        System.out.println(result);
    }
}
