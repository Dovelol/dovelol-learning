package com.dove.lol.dovelol.demo.thread.date201712.demo20171217.future;

/**
 * @author Dovelol
 * @date 2017/12/17 12:10
 */
public class AsynFuture<T> implements Future<T> {

    private volatile boolean done = false;

    private T result;

    public void done(T result){
        synchronized (this){
            this.result = result;
            this.done = true;
            this.notifyAll();
        }
    }

    @Override
    public T get() throws InterruptedException {
        synchronized (this) {
            if (!done) {
                this.wait();
            }
        }
        return result;
    }
}
