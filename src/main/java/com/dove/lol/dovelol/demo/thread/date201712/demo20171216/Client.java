package com.dove.lol.dovelol.demo.thread.date201712.demo20171216;

/**
 * @author Dovelol
 * @date 2017/12/16 16:44
 */
public class Client {

    public static void main(String[] args) {
        Gate gate = new Gate();
        User user1 = new User("Baobao", "BeiJing", gate);
        User user2 = new User("Shanghai", "ShangHai", gate);
        User user3 = new User("Guangzhou", "GuangZhou", gate);
        user1.start();
        user2.start();
        user3.start();
    }
}
