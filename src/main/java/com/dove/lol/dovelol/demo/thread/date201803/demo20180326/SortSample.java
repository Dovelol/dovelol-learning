package com.dove.lol.dovelol.demo.thread.date201803.demo20180326;

import java.util.Arrays;

/**
 * @author Dovelol
 * @date 2018/3/26 23:25
 */
public class SortSample {

    public static void main(String[] args) {
        //基本类型
        int[] array1 = {5, 2, 1, 6, 2, 3, 1, 7, 9, 0};
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));

        //对象类型
        Integer[] array2 = {5, 2, 1, 6, 2, 3, 1, 7, 9, 0};
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));

        Student[] array3 = {new Student(1, "1"), new Student(2, "2"),
                new Student(3, "3"), new Student(4, "4")};
        Arrays.sort(array3);
        System.out.println(Arrays.toString(array3));
//        List<Integer> list = Arrays.asList(array1);
//        Collections.sort(list);
//        list.sort(null);
//        System.out.println(list);

    }

}

class Student {
    private int age;
    private String name;


    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
