package com.dove.lol.dovelol.demo.date201901.demo20190103;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Dovelol
 * @date 2019/1/3 21:52
 */
public class CopyOnWriteArrayListSample {


    public static void main(String[] args) {

        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        copyOnWriteArrayList.add(5);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(8);
        copyOnWriteArrayList.add(7);
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.get(1);
        copyOnWriteArrayList.size();

        System.out.println(copyOnWriteArrayList);


        Object[] elements = new Object[3];
        elements[0] = 1;
        elements[1] = 2;
        elements[2] = 3;
        int len = elements.length;
        Object[] newElements = Arrays.copyOf(elements, len + 1);
        //System.arraycopy(elements, 0, newElements, 0, len + 1);
        newElements[len] = 5;
        System.out.println(Arrays.toString(newElements));

    }

}
