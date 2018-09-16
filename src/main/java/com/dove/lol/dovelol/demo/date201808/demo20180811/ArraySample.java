package com.dove.lol.dovelol.demo.date201808.demo20180811;

/**
 * @author Dovelol
 * @date 2018/8/11 15:29
 */
public class ArraySample {

    private static String s = "abc";

    static {
        int a = 0;
    }

    static {
        int b = 1;
    }

    public static void main(String[] args) {
        Student[] studentArr = new Student[]{};
        ArraySample arraySample = new ArraySample();
        int i = arraySample.hashCode();
        System.out.println(i);
        System.out.println(s);
        int a = 100;
        int b = 200;
        System.out.println(a * b);

        int c = (int) 2000L;

        for (int index = 0; index < 10; index++){
            System.out.println("yzh");
        }

    }


}

class Student {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
