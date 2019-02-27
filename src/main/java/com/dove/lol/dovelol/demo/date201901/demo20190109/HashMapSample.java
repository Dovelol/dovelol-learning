package com.dove.lol.dovelol.demo.date201901.demo20190109;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2019/1/9 21:15
 */
public class HashMapSample {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        //return putVal(hash(key), key, value, false, true);
        map.put(2, "aaa");
        map.put(3, "bbb");
        //return putVal(hash(key), key, value, true, true);
        map.putIfAbsent(5,"abc");
        System.out.println(hash(2));
        System.out.println(new Integer(2).hashCode());
        System.out.println("2".hashCode());

        System.out.println(Integer.toBinaryString(2));

        System.out.println(Integer.toBinaryString(2 >>> 16));
        System.out.println(Integer.toBinaryString(2*2*2*2));


        try {

        }catch(Exception exception){

        }

        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
