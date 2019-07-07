package com.dove.lol.dovelol.demo.date201907.demo20190704;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dovelol
 * @date 2019/7/4 22:49
 */
public class LockDemo {

    private static  Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();


    public static void main(String[] args) {


    }
}
