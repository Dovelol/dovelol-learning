package com.dove.lol.dovelol.demo.date201712.demo20171216.observer1;

/**
 * @author Dovelol
 * @date 2017/12/16 10:22
 */
public class ObserverClient {

    public static void main(String[] args) {
        final Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        System.out.println("========");
        subject.setState(10);
        System.out.println("========");
        subject.setState(10);
        System.out.println("========");
        subject.setState(15);
    }
}
