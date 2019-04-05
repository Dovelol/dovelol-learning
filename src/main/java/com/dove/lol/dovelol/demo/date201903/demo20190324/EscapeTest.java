package com.dove.lol.dovelol.demo.date201903.demo20190324;

// Run with
// java -XX:+PrintGC -XX:+DoEscapeAnalysis EscapeTest

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @author Dovelol
 * @date 2019/3/24 16:43
 */
public class EscapeTest {

    public static void forEach(ArrayList<Object> list, Consumer<Object> f) {
        for (Object obj : list) {
            f.accept(obj);
        }
    }

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (int i = 0; i < 400_000_000; i++) {
            forEach(list, obj -> {
            });
        }
    }
}

