package com.dove.lol.dovelol.demo.date201901.demo20190119;

import java.util.Arrays;

/**
 * @author Dovelol
 * @date 2019/1/19 15:29
 */
public class EnumSample {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(CounterEnum.values()));
    }

}


 enum  CounterEnum {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private int value;

     CounterEnum(int value) {
         this.value = value;
     }

     @Override
     public String toString() {
         return "CounterEnum{" +
                 "value=" + value +
                 '}';
     }
 }