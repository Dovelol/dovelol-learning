package com.dove.lol.dovelol.demo.thread.date201712.demo20171211;

/**
 * @author Dovelol
 * @date 2017/12/11 21:47
 */
public class SingletonObject3 {

    private static SingletonObject3 instance;

    private SingletonObject3() {

    }

    public synchronized static SingletonObject3 getInstance() {
        if (instance == null) {
            instance = new SingletonObject3();
        }
        return instance;
    }
}
