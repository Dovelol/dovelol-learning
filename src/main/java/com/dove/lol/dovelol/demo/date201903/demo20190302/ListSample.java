package com.dove.lol.dovelol.demo.date201903.demo20190302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Dovelol
 * @date 2019/3/2 13:02
 */
public class ListSample {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));

        list.iterator().forEachRemaining(System.out::println);


//        for (Integer integer : list) {
//            list.remove(integer);
//        }
    }

}
