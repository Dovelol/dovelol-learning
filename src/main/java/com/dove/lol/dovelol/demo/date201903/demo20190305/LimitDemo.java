package com.dove.lol.dovelol.demo.date201903.demo20190305;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Date;

/**
 * @author Dovelol
 * @date 2019/3/5 22:37
 */
public class LimitDemo {

    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(0.1);
        for (int i = 0; i < 10; i++) {
            double acquire = limiter.acquire();
            System.out.println("获取令牌成功！，消耗=" + acquire + " time=" + System.currentTimeMillis());


        }


    }


}
