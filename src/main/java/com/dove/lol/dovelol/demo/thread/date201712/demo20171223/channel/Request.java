package com.dove.lol.dovelol.demo.thread.date201712.demo20171223.channel;

/**
 * @author Dovelol
 * @date 2017/12/23 10:28
 */
public class Request {

    private final String name;

    private final int number;

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + " executed" + this);
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
