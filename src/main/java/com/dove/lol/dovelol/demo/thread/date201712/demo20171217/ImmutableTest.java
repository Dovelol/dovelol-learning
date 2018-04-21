package com.dove.lol.dovelol.demo.thread.date201712.demo20171217;

import java.util.Collections;
import java.util.List;

/**
 * @author Dovelol
 * @date 2017/12/17 10:32
 */
public class ImmutableTest {

    private final int age;

    private final String name;

    private final List<String> list;

    public ImmutableTest(int age, String name, List<String> list) {
        this.age = age;
        this.name = name;
        this.list = list;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }
}
