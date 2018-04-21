package com.dove.lol.dovelol.demo.date201712.demo20171217;

/**
 * @author Dovelol
 * @date 2017/12/17 10:16
 */
public class UsePersonThread extends Thread {

    private Person person;

    public UsePersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " print " + person.toString());
        }
    }
}
