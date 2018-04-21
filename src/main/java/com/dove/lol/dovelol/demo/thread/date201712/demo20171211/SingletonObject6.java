package com.dove.lol.dovelol.demo.thread.date201712.demo20171211;

/**
 * @author Dovelol
 * @date 2017/12/11 22:16
 */
public class SingletonObject6 {

    private SingletonObject6() {

    }

    private static class InstanceHolder {
        private final static SingletonObject6 instance = new SingletonObject6();
    }

    public static SingletonObject6 getInstance() {
        return InstanceHolder.instance;
    }
}
