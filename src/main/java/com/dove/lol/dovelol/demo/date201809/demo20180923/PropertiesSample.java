package com.dove.lol.dovelol.demo.date201809.demo20180923;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.NavigableSet;
import java.util.Properties;

/**
 * @author Dovelol
 * @date 2018/9/23 9:08
 */
public class PropertiesSample {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("key", "value");
        properties.setProperty("key1", "value1");

        OutputStream out = new FileOutputStream("test.properties");

        properties.store(out, "test");


    }

}
