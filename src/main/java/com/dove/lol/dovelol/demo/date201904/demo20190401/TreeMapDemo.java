package com.dove.lol.dovelol.demo.date201904.demo20190401;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dovelol
 * @date 2019/4/1 23:20
 */
public class TreeMapDemo {


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        ValueComparator valueComparator = new ValueComparator(map);

        Map<String, Integer> treeMap = new TreeMap<>(valueComparator);


        map.put("D", 20);
        map.put("A", 25);
        map.put("Z", 5);
        map.put("G", 11);
        map.put("B", 10);
        map.put("E", 99);


        treeMap.putAll(map);

        treeMap.forEach((k, v) -> {
            System.out.println(k + "===" + v);
        });


    }

}


class ValueComparator implements Comparator<String> {

    Map<String, Integer> base;

    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.
    @Override
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}