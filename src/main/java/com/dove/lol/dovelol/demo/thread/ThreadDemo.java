package com.dove.lol.dovelol.demo.thread;

public class ThreadDemo {

    public static void main(String[] args) {
        ThreadDemo d = new ThreadDemo() {
            @Override
            protected void test() {
                System.out.println("test-1");
            }
        };
        d.test();
        System.out.println(1<<24);
    }

    protected void test() {

    }
}
