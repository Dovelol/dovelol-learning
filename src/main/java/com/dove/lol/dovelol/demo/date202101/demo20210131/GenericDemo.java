package com.dove.lol.dovelol.demo.date202101.demo20210131;

import java.lang.reflect.Type;
import java.util.Objects;

/**
 * @author Dovelol
 * @date 2021/1/31 10:43
 */
public class GenericDemo<T> {

    private T key;

    public GenericDemo(T key) {
        this.key = key;
    }

    public T getKey(){
        return key;
    }
}
