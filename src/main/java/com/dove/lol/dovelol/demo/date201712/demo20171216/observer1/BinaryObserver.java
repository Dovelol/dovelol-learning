package com.dove.lol.dovelol.demo.date201712.demo20171216.observer1;

/**
 * @author Dovelol
 * @date 2017/12/16 10:19
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Binary :" + Integer.toBinaryString(subject.getState()));
    }
}
