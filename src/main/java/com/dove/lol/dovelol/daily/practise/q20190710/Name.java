package com.dove.lol.dovelol.daily.practise.q20190710;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dovelol
 * @date 2019/7/11 22:49
 */
public class Name {

    /**
     *  以上程序输出内容是？
     *
     *  (a) true
     *  (b) false
     *  (c) 程序编译错误
     *  (d) 以上都不是
     */
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

    @Override
    public int hashCode() {
        return 31 * first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set s = new HashSet();
        s.add(new Name("Mickey", "Mouse"));
        System.out.println(s.contains(new Name("Mickey", "Mouse")));
    }
}
