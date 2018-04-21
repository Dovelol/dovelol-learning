package com.dove.lol.dovelol.demo.thread.date201712.demo20171210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2017/12/10 11:50
 */
public class SimpleThreadPool {

    private final int size;

    private final int queueSize;

    private static final int DEFAULT_SIZE = 10;

    private static final int DEFAULT_TASK_QUEUE_SIZE = 2000;

    private static volatile int seq = 0;

    private static final String THREAD_PREFIX = "SIMPLE_THREAD_POOL";

    private static final ThreadGroup GROUP = new ThreadGroup("Pool_Group");

    private static final LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    private static final List<WorkerTask> THREAD_QUEUE = new ArrayList<>();

    private final DiscardPolicy discardPolicy;

    private volatile boolean destroy = false;

    public static final DiscardPolicy DEFAULT_DISCARD_POLICY = () -> {
        throw new DiscardException("Discard This Task.");
    };

    public SimpleThreadPool() {
        this(DEFAULT_SIZE, DEFAULT_TASK_QUEUE_SIZE, DEFAULT_DISCARD_POLICY);
    }

    public SimpleThreadPool(int size, int queueSize, DiscardPolicy discardPolicy) {
        this.size = size;
        this.queueSize = queueSize;
        this.discardPolicy = discardPolicy;
        init();
    }

    private void init() {
        for (int i = 0; i < size; i++) {
            createWorkTask();
        }
    }

    public void submit(Runnable runnable) {
        if (destroy) {
            throw new IllegalStateException("The thread pool already destroy and not allow submit task.");
        }

        synchronized (TASK_QUEUE) {
            if (TASK_QUEUE.size() > queueSize) {
                discardPolicy.discard();
            }
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();

        }

    }

    private void createWorkTask() {
        WorkerTask task = new WorkerTask(GROUP, THREAD_PREFIX + (seq++));
        task.start();
        THREAD_QUEUE.add(task);
    }

    public void shutdown() throws InterruptedException {
        while (!TASK_QUEUE.isEmpty()) {
            TimeUnit.MILLISECONDS.sleep(50);
        }
        int initVal = THREAD_QUEUE.size();
        while (initVal > 0) {
            for (WorkerTask workerTask : THREAD_QUEUE) {
                if (workerTask.taskState == TaskState.BLOCKED) {
                    workerTask.interrupt();
                    workerTask.close();
                    initVal--;
                } else {
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            }
        }
        this.destroy = true;
        System.out.println("The thread pool disposed.");
    }

    public int getQueueSize() {
        return queueSize;
    }

    public int getSize() {
        return size;
    }

    public boolean isDestroy() {
        return this.destroy;
    }

    private enum TaskState {

        FREE, RUNNING, BLOCKED, DEAD

    }

    public static class DiscardException extends RuntimeException {

        public DiscardException(String message) {
            super(message);
        }

    }


    public interface DiscardPolicy {
        void discard() throws DiscardException;
    }

    private static class WorkerTask extends Thread {

        private volatile TaskState taskState = TaskState.FREE;

        public WorkerTask(ThreadGroup group, String name) {
            super(group, name);
        }

        @Override
        public void run() {
            OUTER:
            while (this.taskState != TaskState.DEAD) {
                Runnable runnable;
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;
                        }
                    }
                    runnable = TASK_QUEUE.removeFirst();
                }
                if (runnable != null) {
                    taskState = TaskState.RUNNING;
                    runnable.run();
                    taskState = TaskState.FREE;
                }
            }
        }

        public TaskState getTaskState() {
            return this.taskState;
        }

        public void close() {
            this.taskState = TaskState.DEAD;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleThreadPool simpleThreadPool = new SimpleThreadPool();
        IntStream.rangeClosed(0, 40).forEach(i -> {
            simpleThreadPool.submit(() -> {
                System.out.println("the runnable " + i + " be serviced by " + Thread.currentThread() + " start");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("the runnable " + i + " be serviced by " + Thread.currentThread() + " finish");
            });
        });

//        for (int i = 0; i < 40; i++) {
//            Thread thread = new Thread() {
//                @Override
//                public void run() {
//                    System.out.println("the runnable " + 1 + " be serviced by " + Thread.currentThread() + " start");
//                    try {
//                        TimeUnit.SECONDS.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("the runnable " + 1 + " be serviced by " + Thread.currentThread() + " finish");
//                }
//            };
//            simpleThreadPool.submit(thread);
//        }

        TimeUnit.SECONDS.sleep(10);
        simpleThreadPool.shutdown();
        simpleThreadPool.submit(()->{
            System.out.println("====");
        });
    }

}
