package com.dove.lol.dovelol.demo.date201809.demo20180905;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author Dovelol
 * @date 2018/9/5 21:39
 */
public class Test2 {

    final static ExecutorService executor = Executors.newFixedThreadPool(2);


    public static void main(String[] args) {
        RpcService rpcService = new RpcService();
        HttpService httpService = new HttpService();

        Future<Map<String, String>> future1 = null;
        Future<Integer> future2 = null;

        future1 = executor.submit(() -> rpcService.getRpcResult());
        future2 = executor.submit(() -> httpService.getHttpResult());

        try {
            Map<String, String> result1 = future1.get(30000, TimeUnit.MILLISECONDS);
            Integer result2 = future2.get(30000, TimeUnit.MILLISECONDS);

            System.out.println(result1.size());

            System.out.println(result2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }

    static class RpcService {
        Map<String, String> getRpcResult() {
            //调用远程方法
            try {
                TimeUnit.MILLISECONDS.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Map<String, String> result = new HashMap<>();
            result.put("name", "dove");
            result.put("age", "27");
            return result;
        }
    }

    static class HttpService {
        Integer getHttpResult() {
            try {
                TimeUnit.MILLISECONDS.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 0;
        }

    }

}
