package com.dove.lol.dovelol.demo.date201901.demo20190103;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Dovelol
 * @date 2019/1/3 22:42
 */
public class LinkedListSample {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(100);
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(11);
        arrayList.add(10);
        arrayList.size();


        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(100);
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(11);
        linkedList.add(10);

        linkedList.add(10,100);

        linkedList.remove(10);
        linkedList.size();
        linkedList.addFirst(1);


    }

}
