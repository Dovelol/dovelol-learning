package com.dove.lol.dovelol.demo.date201712.demo20171209;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2017/12/9 10:02
 */
public class CaptureService {

    private static final LinkedList<Control> CONTROL_LIST = new LinkedList<>();

    public static void main(String[] args) {
        List<Thread> worker = new ArrayList<>();
        Arrays.asList("M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "M10",
                "M11", "M12", "M13", "M14", "M15", "M16", "M17", "M18", "M19", "M20").stream()
                .map(CaptureService::createCaptureThread)
                .forEach(thread -> {
                    thread.start();
                    worker.add(thread);
                });
        worker.stream().forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Optional.of("全部任务完成").ifPresent(System.out::println);

    }


    private static Thread createCaptureThread(String name) {
        return new Thread(() -> {
            synchronized (CONTROL_LIST) {
                while (CONTROL_LIST.size() >= 5) {
                    try {
                        Optional.of(Thread.currentThread().getName() + "准备执行").ifPresent(System.out::println);
                        CONTROL_LIST.wait();
                        Optional.of(Thread.currentThread().getName() + "被唤醒之后").ifPresent(System.out::println);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                CONTROL_LIST.addLast(new Control());
            }

            Optional.of(Thread.currentThread().getName() + "正在工作").ifPresent(System.out::println);
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (CONTROL_LIST) {
                Optional.of(Thread.currentThread().getName() + "结束工作").ifPresent(System.out::println);
                CONTROL_LIST.removeFirst();
                CONTROL_LIST.notifyAll();
            }

        }, name);
    }

    private static class Control {

    }

}
