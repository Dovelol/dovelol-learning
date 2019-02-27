package com.dove.lol.dovelol.demo.date201901.demo20190120;

import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Dovelol
 * @date 2019/1/20 14:09
 */
public class ThreadLocalSample {

    public static void main(String[] args) throws UnsupportedEncodingException, UnknownHostException {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("");


        String str1 = "中文";
        byte[] bytes = str1.getBytes("UTF-8");
        String str2 = new String(bytes, "UTF-8");
        System.out.println(bytes);

        byte[] bytes1 = str1.getBytes("UTF-16");
        System.out.println(bytes1);

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost.getHostAddress());
    }


}
