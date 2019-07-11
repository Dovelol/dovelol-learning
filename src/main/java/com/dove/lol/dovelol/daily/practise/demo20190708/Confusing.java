package com.dove.lol.dovelol.daily.practise.demo20190708;

/**
 * @author Dovelol
 * @date 2019/7/11 22:44
 */
public class Confusing {

    /**
     *  以上程序输出内容是？
     *
     *  (a) Object
     *  (b) double array
     *  (c) 以上都不是
     *
     *
     * 这里应该是most specific 原则吧，所有double[] 类型参数都可以是Object，但不是所有Object都是double[]。所以在这里Confusing(double[] dArray) 更加 specific。选b。
     */
    public Confusing(Object o) {
        System.out.println("Object");
    }
    public Confusing(double[] dArray) {
        System.out.println("double array");
    }
    public static void main(String args[]) {
        new Confusing(null);
    }
}
