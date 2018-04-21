package com.dove.lol.dovelol.demo.thread.date201801.demo20180113;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Dovelol
 * @date 2018/1/13 10:08
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {
        AtomicReference<Simple> simple = new AtomicReference<>(new Simple("dove", 20));
        simple.getAndSet(new Simple("dovelol", 21));
        System.out.println(simple.compareAndSet(new Simple("1",2), new Simple("dovelol", 21)));
    }

    static class Simple {

        private String name;

        private int age;

        public Simple(String name, int age) {
            this.name = name;
            this.age = age;
        }

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

        @Override
        public String toString() {
            return "Simple{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
