package com.dove.lol.dovelol.demo.date201903.demo20190303;

public interface Sort<T extends Comparable<T>> {


    void sort(T[] values);


    static <T> T[] of(T... values) {
        return values;
    }

}
