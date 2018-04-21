package com.dove.lol.dovelol.demo.thread.date201712.demo20171216;

import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/16 11:29
 */
public class Gate {

    private int counter = 0;

    private String name = "Nobody";

    private String address = "Nowhere";

    public  void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        verify();
    }

    private void verify() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("**********BROKEN***********" + toString());
        }
    }

    @Override
    public String toString() {
        return "Gate{" +
                "counter=" + counter +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
