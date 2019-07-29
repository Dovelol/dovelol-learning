package com.dove.lol.dovelol.daily.practise.q20190729;

/**
 * @author Dovelol
 * @date 2019/7/29 20:39
 */
public class Parsing {


    /**
     *  以上程序输出内容是？

     *  (a) 运行时异常
     *  (b) -1 null 1
     *  (c) -1 0 1
     *  (d) 编译错误
     */

    /**
     * Returns Integer corresponding to s, or null if s is null.
     * @throws NumberFormatException if s is nonnull and
     * doesn't represent a valid integer
     */
    public static Integer parseInt(String s) {
        return (s == null) ?
                (Integer) null : Integer.parseInt(s);
    }
    public static void main(String[] args) {
        System.out.println(parseInt("-1") + " " +
                parseInt(null) + " " +
                parseInt("1"));
    }

}
