package com.dove.lol.dovelol.demo.date201904.demo20190401;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/**
 * @author Dovelol
 * @date 2019/4/1 20:13
 */
public class LogAnalysis {

    public static Pattern logPattern = Pattern.compile("\\[(.*?)\\]\\[(.*?)\\]\\[(.*?)\\.\\d{3}\\].*");

    public static void main(String[] args) {
        String log = "[thread-1][100000][2019-03-15 13:07:42.164]login\n" +
                "[thread-1][100000][2019-03-15 13:07:42.165]read db\n" +
                "[thread-1][100000][2019-03-15 13:07:42.166]return json to frontend\n" +
                "[thread-2][100001][2019-03-15 13:07:47.102]login";
        //解析


        Map<String, Long> map1 = new TreeMap<>();
        Map<Long, Long> map2 = new HashMap<>();

        logCounterBySecond("2019-03-15 13:07:42", map1);
        logCounterByReq(100001L, map2);

        System.out.println(avgLogByReq(map2));
    }

    /**
     * 计算每秒的日志数量
     *
     * @param time
     * @param map
     */
    public static void logCounterBySecond(String time, Map<String, Long> map) {
        map.put(time, map.get(time) + 1);
    }

    /**
     * 计算每个请求的日志数量
     *
     * @param reqId 请求id
     * @param map
     */
    public static void logCounterByReq(Long reqId, Map<Long, Long> map) {
        map.put(reqId, map.get(reqId) + 1);
    }

    /**
     * 计算平均每个请求产生多少条日志
     *
     * @param map
     * @return
     */
    public static double avgLogByReq(Map<Long, Long> map) {
        int reqCount = map.size();
        Long logCount = 0L;
        for (Long value : map.values()) {
            logCount = logCount + value;
        }
        return (double) logCount / reqCount;
    }


}
