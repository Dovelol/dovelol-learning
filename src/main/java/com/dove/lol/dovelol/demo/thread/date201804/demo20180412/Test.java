package com.dove.lol.dovelol.demo.thread.date201804.demo20180412;

/**
 * @author Dovelol
 * @date 2018/4/12 22:09
 */
public class Test {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));

        System.out.println(((82765.34*2.1489-170000*1.05)*0.8+170000*1.05)*15/17);
    }

}
