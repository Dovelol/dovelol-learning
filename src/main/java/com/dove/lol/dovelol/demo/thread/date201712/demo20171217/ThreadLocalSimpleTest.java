package com.dove.lol.dovelol.demo.thread.date201712.demo20171217;

import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/17 18:48
 */
public class ThreadLocalSimpleTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal(){
        @Override
        protected String initialValue() {
            return "dovelol";
        }
    };

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set("dovelol");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(threadLocal.get());
    }

}
