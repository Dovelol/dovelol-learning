package com.dove.lol.dovelol.demo.thread.date201712.demo20171211;

/**
 * @author Dovelol
 * @date 2017/12/11 21:39
 */
public class SingletonObject1 {

    private static SingletonObject1 instance = new SingletonObject1();

    private SingletonObject1() {

    }

    public static SingletonObject1 getInstance() {
        return instance;
    }

}
