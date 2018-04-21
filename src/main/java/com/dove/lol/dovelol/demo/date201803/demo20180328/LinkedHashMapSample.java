package com.dove.lol.dovelol.demo.date201803.demo20180328;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Dovelol
 * @date 2018/3/28 21:59
 */
public class LinkedHashMapSample<K,V> extends LinkedHashMap<K,V>{

    public static void main(String[] args) {
        LinkedHashMapSample<Integer, String> linkedHashMap = new LinkedHashMapSample<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            linkedHashMap.put(random.nextInt(100000), "" + i);
        }
        System.out.println(linkedHashMap.get(4));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            System.out.println(linkedHashMap.removeEldestEntry(entry));
        }
    }
}
