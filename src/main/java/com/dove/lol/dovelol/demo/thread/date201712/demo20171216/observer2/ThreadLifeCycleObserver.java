package com.dove.lol.dovelol.demo.thread.date201712.demo20171216.observer2;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/16 10:55
 */
public class ThreadLifeCycleObserver implements LifeCycleListener {

    private final Object LOCK = new Object();

    public void concurrentQuery(List<String> ids) {

        if (ids == null || ids.isEmpty()) {
            return;
        }

        ids.stream().forEach(id -> {
            new Thread(new ObservableRunnable(this) {
                @Override
                public void run() {
                    try {
                        notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
                        System.out.println("query for the id " + id);
                        TimeUnit.SECONDS.sleep(2);
                        notifyChange(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));
                    } catch (Exception e) {
                        notifyChange(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), e));
                    }
                }
            }, id).start();
        });
    }

    @Override
    public void onEvent(ObservableRunnable.RunnableEvent event) {
        synchronized (LOCK) {
            System.out.println("The Runnable [" + event.getThread().getName() + "] data changed and state is [" + event.getState() + "]");
            if (event.getCause() != null) {
                System.out.println("The Runnable [" + event.getThread().getName() + "] process failed.");
                event.getCause().printStackTrace();
            }
        }
    }
}
