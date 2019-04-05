package com.dove.lol.dovelol.demo.date201904.demo20190401;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Dovelol
 * @date 2019/4/1 20:48
 */
public class LogHandler {

    public static Pattern logPattern = Pattern.compile("\\[(.*?)\\]\\[(.*?)\\]\\[(.*?)\\.\\d{3}\\].*");

    public void countLog(String logs) {
        if (logs == null || "".equals(logs)) {
            return;
        }
        String[] logArr = logs.split("\n\r");
        Map<String, Integer> reqCountMap = new HashMap<String, Integer>();
        Map<String, Integer> timeCountMap = new HashMap<String, Integer>();
        for (String log : logArr) {
            Matcher m = logPattern.matcher(log);
            m.find();
            String requestId = m.group(1);
            addMapCount(requestId, reqCountMap);
            String time = m.group(2);
            addMapCount(time, timeCountMap);
        }
        int divide = 0;
        int sum = 0;
        for (Integer v : reqCountMap.values()) {
            divide++;
            sum += v;
        }
        double result = divide == 0 ? 0 : (sum * 1.0) / divide;
        System.out.println("平均每个请求产生：" + result + "条日志");

        String maxSec = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : timeCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxSec = entry.getKey();
            }
        }
        System.out.println(maxSec + "产生最多日志，数量为" + maxCount);
    }

    private void addMapCount(String key, Map<String, Integer> reqCountMap) {
        Integer count = reqCountMap.get(key);
        if (count == null) {
            reqCountMap.put(key, 1);
        } else {
            reqCountMap.put(key, ++count);
        }
    }

    public static void main(String[] args) {
        LogHandler logHandler = new LogHandler();
        String log = "[thread-1][100000][2019-03-15 13:07:42.164]login\n\r" +
                "[thread-1][100000][2019-03-15 13:07:42.165]read db\n\r" +
                "[thread-1][100000][2019-03-15 13:07:42.166]return json to frontend\n\r" +
                "[thread-2][100001][2019-03-15 13:07:47.102]login\n\r";
        logHandler.countLog(log);
    }

}

