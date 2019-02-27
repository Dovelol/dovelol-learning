package com.dove.lol.dovelol.demo.date201901.demo20190119;

/**
 * @author Dovelol
 * @date 2019/1/19 16:05
 */
public class IntegerDemo {

    public static void main(String[] args) {
        int value4 = 99;

        Integer value = 99;
        Integer value2 = new Integer(99);
        Integer value3 = Integer.valueOf(99);
        //Integer.equals比较的是值
        System.out.println("value.equals(value2):" + value.equals(value2));//true
        System.out.println("value.equals(value3):" + value.equals(value3));//true

        System.out.println("value == value2:" + (value == value2));//false
        System.out.println("value == value3:" + (value == value4));//true
    }


}
