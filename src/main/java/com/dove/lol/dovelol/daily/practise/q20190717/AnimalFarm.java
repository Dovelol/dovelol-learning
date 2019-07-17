package com.dove.lol.dovelol.daily.practise.q20190717;

/**
 * @author Dovelol
 * @date 2019/7/17 21:23
 */
public class AnimalFarm {

    /**
     * 以上程序输出内容是？

     *  (a) Animals are equal: true
     *  (b) Animals are equal: false
     *  (c) 编译错误
     *  (d) 以上答案都不对
     */

    public static void main(String[] args) {
        final String pig = "length: 10";
        final String dog = "length: " + pig.length();
        System.out.println("Animals are equal: "
                + pig == dog);
    }

}
