package com.dove.lol.dovelol.demo.thread.date201801.demo20180128;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author Dovelol
 * @date 2018/1/28 19:55
 */
public class ExecutorServiceSample1 {


    public static void main(String[] args) throws InterruptedException {
        //isShutDown();
        //isTerminated();
        //executeRunnableError();
        executeRunnableTask();
    }

    private static void isShutDown() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(executorService.isShutdown());
        executorService.shutdown();
        System.out.println(executorService.isShutdown());

    }

    private static void isTerminated() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdownNow();
        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
        System.out.println(((ThreadPoolExecutor) executorService).isTerminating());
    }

    private static void executeRunnableError() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10, new MyThreadFactory());
        executorService.execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        IntStream.range(0, 10).boxed().forEach(integer -> executorService.execute(() -> {
            System.out.println(1 / 0);
        }));

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("=================");
    }

    /**
     * <pre>
     *                                      丨--->
     *                                      丨--->
     * send request ---> store db ---> 10-> 丨--->
     *                                      丨--->
     *                                      丨--->
     * </pre>
     */
    private static void executeRunnableTask() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10, new MyThreadFactory());
        IntStream.range(0, 10).boxed().forEach(integer -> executorService.execute(
            new MyTask(integer) {

                @Override
                protected void error(Throwable t) {
                    System.out.println("The no:" + integer + " failed, update statue to Error.");
                }

                @Override
                protected void done() {
                    System.out.println("The no:" + integer + " successfully, update statue to Dene.");
                }

                @Override
                protected void doExecute() {
                    if (integer % 3 == 0) {
                        int tem = integer / 0;
                    }
                }

                @Override
                protected void doInit() {
                    //do things.
                }
        }));

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("=================");
    }

    private abstract static class MyTask implements Runnable {

        private final int no;

        public MyTask(int no) {
            this.no = no;
        }

        @Override
        public void run() {
            try {
                this.doInit();
                this.doExecute();
                this.done();
            } catch (Throwable t) {
                this.error(t);

            }

        }

        protected abstract void error(Throwable t);

        protected abstract void done();

        protected abstract void doExecute();

        protected abstract void doInit();
    }


    private static class MyThreadFactory implements ThreadFactory {

        private static final AtomicInteger SEQ = new AtomicInteger();

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("My-Thread" + SEQ.getAndIncrement());
            thread.setUncaughtExceptionHandler((t, cause) -> {
                System.out.println("The thread " + t.getName() + " execute failed. ");
                cause.printStackTrace();
                System.out.println("==================");
            });
            return thread;
        }
    }


}
