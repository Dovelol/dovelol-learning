package com.dove.lol.dovelol.daily.practise.q20190813;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * @author Dovelol
 * @date 2019/8/13 23:08
 */
public class MyMap {

    /**
     *  以上程序输出内容是？
     *  (a) Hello 1 null 3
     *  (b) World 1 null 2
     *  (c) Hello 2 null 2
     *  (d) 以上答案都不是
     *
     */

    public static void main(String[] args) {
        Map map = new IdentityHashMap<>();
        map.put(1, "Hello");
        map.putIfAbsent(1, "World");
        print(map.get(1));
        print(map.size());

        map.put(1024, "A");
        map.putIfAbsent(1024, "B");
        print(map.get(1024));
        print(map.size());

    }

    private static void print(Object object) {
        System.out.print(object + " ");
    }

}
