package com.dove.lol.dovelol.demo.date201904.demo20190411;

/**
 * @author Dovelol
 * @date 2019/4/11 23:08
 */
public class ThreadDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(ThreadDemo::helloWorld);
    }

    static void helloWorld(){
        System.out.println("Hello World");
    }

    static void helloWorld1(){
        System.out.println("Hello World");
        new RuntimeException().getStackTrace();
    }


}
