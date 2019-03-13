package com.dove.lol.dovelol.demo.date201903.demo20190302;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Dovelol
 * @date 2019/3/2 9:29
 */
public class ReferenceSample {

    private static final int _1M = 1*1024*1024*1024;

    private static final int _8M = 8*1024*1024*1024;

    public static void main(String[] args) {
        ReferenceQueue<User> queue = new ReferenceQueue<>();



        WeakReference<User> reference = new WeakReference<User>(new User("zhangsan"), queue);

        test();
        for (int i = 0; i < 10000; i ++){
            byte[] tmp = new byte[_1M];
        }

        System.out.println(reference.get());

        System.out.println(reference.enqueue());

        WeakReference<User> r = (WeakReference<User>) queue.poll();
        System.out.println(r.get() == reference.get());
        System.out.println(r == reference);
        System.out.println(queue.poll());

        // 预期YoungGC的次数
        int ygcTime = 3;

        for (int i=0; i<ygcTime; i++){
            // 由于Eden区设置为8M, 所以分配8个1M就会导致一次YoungGC
            for(int j=0; j<8000000; j++){
                byte[] tmp = new byte[_1M];
            }
        }

        for(int j=0; j<3000000; j++) {
            // 对象超过了Eden区, 所以直接在Old区分配;
            byte[] tmp = new byte[_8M];
        }

        try {
            // sleep一段时间是为了让CMS GC线程能够有足够的时间检测到Old区达到了触发CMS GC的条件，CMS GC线程默认2s扫描一次，可以通过参数CMSWaitDuration配置，例如-XX:CMSWaitDuration=3000
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static void test(){
        for (int i = 0; i < 10000; i ++){
            byte[] tmp = new byte[_1M];
        }
    }


    private static class User {

        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
