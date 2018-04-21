package com.dove.lol.dovelol.demo.date201803.demo20180319;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Dovelol
 * @date 2018/3/19 23:10
 */
public class SetSample {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        System.out.println(set.add("sss"));
        System.out.println(set.add("sss"));
        System.out.println(set.add(null));
        System.out.println(set.add(null));

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("lll");

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("ttt");
    }
}
