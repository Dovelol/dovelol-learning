package com.dove.lol.dovelol.demo.date201712.demo20171211;

import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2017/12/11 22:34
 */
public class SingletonObject7 {

    private SingletonObject7() {

    }

    private enum Singleton {
        /**
         *
         */
        INSTANCE;

        private final SingletonObject7 instance;

        Singleton() {
            instance = new SingletonObject7();
        }

        public SingletonObject7 getInstance() {
            return instance;
        }
    }

    public static SingletonObject7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).forEach(i ->
                new Thread(() ->
                        System.out.println(SingletonObject7.getInstance())
                ).start()
        );
    }


}
