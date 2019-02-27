package com.dove.lol.dovelol.demo.date201901.demo20190114;

import java.util.LinkedHashMap;

/**
 * @author Dovelol
 * @date 2019/1/14 23:10
 */
public class LinkedHashMapSample {

    public static void main(String[] args) {
        LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(5,"book");
        linkedHashMap.put(2,"book");
        linkedHashMap.put(11,"book");
        linkedHashMap.put(7,"book");
        linkedHashMap.put(8,"book");

        String str = "";

        Data data = new Data();

    }

}


class Data{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}