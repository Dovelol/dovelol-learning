package com.dove.lol.dovelol.daily.practise.q20190718;

/**
 * @author Dovelol
 * @date 2019/7/18 22:43
 */
public class Lazy {

    /**
     *  以上程序输出内容是？
     *  (a) true
     *  (b) false
     *  (c) 编译错误
     *  (d) 以上答案都不对
     */

    private static boolean initialized = false;

    static {
        Thread t = new Thread(() -> initialized = true);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(initialized);
    }


}
