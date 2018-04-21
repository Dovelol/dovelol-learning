package com.dove.lol.dovelol.demo.thread.date201712.demo20171216.observer1;

/**
 * @author Dovelol
 * @date 2017/12/16 10:14
 */
public abstract class Observer {

    protected Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public abstract void update();


}
