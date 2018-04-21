package com.dove.lol.dovelol.demo.date201712.demo20171216;

/**
 * @author Dovelol
 * @date 2017/12/16 16:41
 */
public class User extends Thread {

    private final String MY_NAME;

    private final String MY_ADDRESS;

    private final Gate GATE;

    public User(String MY_NAME, String MY_ADDRESS, Gate GATE) {
        this.MY_NAME = MY_NAME;
        this.MY_ADDRESS = MY_ADDRESS;
        this.GATE = GATE;
    }

    @Override
    public void run() {
        System.out.println(MY_NAME + " BEGIN");
        while (true) {
            this.GATE.pass(MY_NAME, MY_ADDRESS);
        }
    }
}
