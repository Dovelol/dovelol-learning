package com.dove.lol.dovelol.demo.date201907.demo20190710;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dovelol
 * @date 2019/7/10 21:20
 */
public class Name {
    private String first, last;

    public Name(String first, String last) {
        if (first == null || last == null)
            throw new NullPointerException();
        this.first = first;
        this.last = last;
    }

    public boolean equals(Name o) {
        return first.equals(o.first) && last.equals(o.last);
    }

    public int hashCode() {
        return 31 * first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set s = new HashSet();
        s.add(new Name("Mickey", "Mouse"));
        System.out.println(s.contains(new Name("Mickey", "Mouse")));
    }
}
