package com.dove.lol.dovelol.demo.date201901.demo20190110;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Dovelol
 * @date 2019/1/10 22:25
 */
public class ConcurrentHashMapSample {

    public static void main(String[] args) {
        Map<Integer, String> map = new ConcurrentHashMap<>();
        //return putVal(key, value, false);
        map.put(12, "yyy");

        map.put(20, "abc");
        //return putVal(key, value, true);
        map.putIfAbsent(15, "absent");
    }


}
