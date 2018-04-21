package com.dove.lol.dovelol.demo.date201803.demo20180328;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Dovelol
 * @date 2018/3/28 23:24
 */
public class CloneSample {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student();
        Student clone = (Student) student.clone();
        System.out.println(student == clone);
        System.out.println(student.getAge());
        clone.setAge(10);
        System.out.println(student.getAge());
        System.out.println(clone.getAge());
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("dove");
        ArrayList<String> clone1 = (ArrayList<String>) arrayList.clone();
        System.out.println(Objects.equals(clone1.get(0), arrayList.get(0)));
    }

}

