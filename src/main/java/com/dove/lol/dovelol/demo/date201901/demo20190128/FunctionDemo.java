package com.dove.lol.dovelol.demo.date201901.demo20190128;

import java.util.function.Function;

/**
 * @author Dovelol
 * @date 2019/1/28 22:58
 */
public class FunctionDemo {

    public static void main(String[] args) {
        Function<String,Long> stringToLang = Long::valueOf;

        System.out.println(stringToLang.apply("1"));

    }


}
