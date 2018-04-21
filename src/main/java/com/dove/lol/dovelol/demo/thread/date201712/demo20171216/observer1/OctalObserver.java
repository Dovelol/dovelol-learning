package com.dove.lol.dovelol.demo.thread.date201712.demo20171216.observer1;

/**
 * @author Dovelol
 * @date 2017/12/16 10:22
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Octal :" + Integer.toOctalString(subject.getState()));
    }
}
