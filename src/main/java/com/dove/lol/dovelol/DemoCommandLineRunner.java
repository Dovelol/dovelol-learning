package com.dove.lol.dovelol;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Dovelol
 * @date 2020/7/22 21:47
 */
@Component
public class DemoCommandLineRunner implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        System.out.println("DemoCommandLineRunner: "+args);
    }
}
