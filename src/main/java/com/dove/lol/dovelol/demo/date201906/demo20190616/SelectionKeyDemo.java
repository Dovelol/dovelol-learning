package com.dove.lol.dovelol.demo.date201906.demo20190616;

import java.nio.channels.SelectionKey;

/**
 * @author Dovelol
 * @date 2019/6/16 23:07
 */
public class SelectionKeyDemo {
    public static void main(String[] args) {
        System.out.println(SelectionKey.OP_ACCEPT);
        System.out.println(SelectionKey.OP_ACCEPT|256);
        System.out.println(SelectionKey.OP_READ);
        System.out.println(SelectionKey.OP_READ|256);
        System.out.println(SelectionKey.OP_CONNECT);
        System.out.println(SelectionKey.OP_CONNECT|256);
        System.out.println(SelectionKey.OP_WRITE);
        System.out.println(SelectionKey.OP_WRITE|256);
    }
}
