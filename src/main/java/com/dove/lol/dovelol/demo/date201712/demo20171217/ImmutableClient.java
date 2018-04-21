package com.dove.lol.dovelol.demo.date201712.demo20171217;

import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2017/12/17 10:17
 */
public class ImmutableClient {

    public static void main(String[] args) {
        Person person = new Person("yuanzheng", "zhengzhou");

        IntStream.rangeClosed(0, 5).forEach(i -> {
            new UsePersonThread(person).start();
        });
    }
}
