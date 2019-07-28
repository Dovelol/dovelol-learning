package com.dove.lol.dovelol.demo.date201907.demo20190728;

import java.lang.management.ManagementFactory;
import java.util.Arrays;

/**
 * @author Dovelol
 * @date 2019/7/28 11:44
 */
public class MemoryPoolsDemo {


    public static void main(String[] args) {
        ManagementFactory.getMemoryManagerMXBeans().forEach(mxbean->{
            System.out.printf("当前 MemoryManagerMXBean 名称：%s 以及它关联的内存池名称：%s\n",mxbean, Arrays.asList(mxbean.getMemoryPoolNames()));
        });
    }

}
