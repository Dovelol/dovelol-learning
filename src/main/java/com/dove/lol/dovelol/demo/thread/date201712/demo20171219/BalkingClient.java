package com.dove.lol.dovelol.demo.thread.date201712.demo20171219;

/**
 * @author Dovelol
 * @date 2017/12/19 22:15
 */
public class BalkingClient {


    public static void main(String[] args) {
        final BalkingData balkingData = new BalkingData("dove.txt", "dovelol");
        new CustomerThread(balkingData).start();
        new WaiterThread(balkingData).start();
    }
}
