package com.dove.lol.dovelol.demo.date201809.demo20180905;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/9/5 21:34
 */
public class Test {

    public static void main(String[] args) throws Exception {
        RpcService rpcService = new RpcService();
        HttpService httpService = new HttpService();

        Map<String, String> result1 = rpcService.getRpcResult();
        Integer result2 = httpService.getHttpResult();


    }

    static class RpcService {
        Map<String, String> getRpcResult() throws Exception {
            //调用远程方法
            TimeUnit.MILLISECONDS.sleep(10);
            Map<String, String> result = new HashMap<>();
            result.put("name", "dove");
            result.put("age", "27");
            return result;
        }
    }

    static class HttpService {
        Integer getHttpResult() throws Exception {
            TimeUnit.SECONDS.sleep(20);
            return 0;
        }

    }


}
