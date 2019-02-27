package com.dove.lol.dovelol.demo.date201901.demo20190128;

import java.util.function.Consumer;

/**
 * @author Dovelol
 * @date 2019/1/28 22:48
 */
public class ConsumerDemo {


    public static void main(String[] args) {
        Consumer<String> consumer = ConsumerDemo::echo;
    }


    public static void echo(String message) {
        System.out.println(message);
    }


}
