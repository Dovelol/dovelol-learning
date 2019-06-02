package com.dove.lol.dovelol.demo.date201905.demo20190528;

import java.io.File;
import java.io.IOException;

/**
 * @author Dovelol
 * @date 2019/5/28 23:06
 */
public class TempDirectoryDemo {

    public static void main(String[] args) throws IOException {
        File tempFile = File.createTempFile("abc", "aaa");
        System.out.println(tempFile.getPath());

    }

}
