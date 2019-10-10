package com.dove.lol.dovelol.demo.date201909.demo20190924;

/**
 * @author Dovelol
 * @date 2019/9/24 22:22
 */
public class UnableToCreateNewNativeThreadOOM {


    public static void main(String[] args) {

        Thread[] array = new Thread[10_000];

        for (int i = 0; i < 100_000;i ++){
            array[i] =  new Thread(()-> System.out.println("abc"));
        }

        for (Thread thread : array){
            thread.start();
        }


    }

}
