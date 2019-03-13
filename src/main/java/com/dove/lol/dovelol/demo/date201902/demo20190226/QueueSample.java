package com.dove.lol.dovelol.demo.date201902.demo20190226;

import java.util.*;

/**
 * @author Dovelol
 * @date 2019/2/26 21:19
 */
public class QueueSample {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList();
        queue.add("123");
        queue.offer("abc");


        List<Object> objects = Collections.emptyList();
        System.out.println(objects);

        List<Object> list = new ArrayList<>();

        System.out.println(list);
    }

}
