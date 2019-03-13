package com.dove.lol.dovelol.demo.date201903.demo20190313;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @author Dovelol
 * @date 2019/3/13 22:16
 */
public class ProcessInfoDemo {

    public static void main(String[] args) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getName());
    }

}
