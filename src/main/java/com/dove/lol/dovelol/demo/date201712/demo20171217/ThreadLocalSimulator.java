package com.dove.lol.dovelol.demo.date201712.demo20171217;

import java.util.HashMap;

/**
 * @author Dovelol
 * @date 2017/12/17 19:15
 */
public class ThreadLocalSimulator<T> {

    private final HashMap<Thread, T> storage = new HashMap<>();

    public T get() {
        synchronized (storage) {
            Thread thread = Thread.currentThread();
            T value = storage.get(thread);
            if (value == null) {
                return initValue();
            }
            return value;
        }
    }

    public void set(T t) {
        synchronized (storage) {
            Thread thread = Thread.currentThread();
            storage.put(thread, t);
        }
    }

    public T initValue() {
        return null;
    }

}
