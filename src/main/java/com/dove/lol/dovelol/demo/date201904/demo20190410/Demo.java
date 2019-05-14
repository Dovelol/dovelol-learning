package com.dove.lol.dovelol.demo.date201904.demo20190410;

import java.util.stream.Stream;

/**
 * @author Dovelol
 * @date 2019/4/10 21:25
 */
public class Demo {

    public static void main(String[] args) {

        int sum = sum(10);
        System.out.println(sum);


    }

    public static int sum(int n){
        if(n==1 || n==2){
            return 1;
        }
        return sum(n-1)+sum(n-2);
    }


}
