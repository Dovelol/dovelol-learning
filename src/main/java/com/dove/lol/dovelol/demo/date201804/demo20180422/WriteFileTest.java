package com.dove.lol.dovelol.demo.date201804.demo20180422;

import com.dove.lol.dovelol.utils.GlobalTheadPool;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Dovelol
 * @date 2018/4/22 11:36
 */
public class WriteFileTest {

    public static void main(String[] args) {
        new Thread(() -> {
            File file = new File("D:\\text.txt");
            try (FileOutputStream fos = new FileOutputStream(file)) {
                TimeUnit.MILLISECONDS.sleep(1);
                for (int i = 0 ; i < 100; i++){
                    String str = "1 wirte file test!";
                    fos.write(str.getBytes());
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            File file = new File("D:\\text.txt");
            try (FileOutputStream fos = new FileOutputStream(file)) {
                TimeUnit.MILLISECONDS.sleep(1);
                for (int i = 0 ; i < 100; i++){
                    String str = "2 wirte file test!";
                    fos.write(str.getBytes());
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            File file = new File("D:\\text.txt");
            try (FileOutputStream fos = new FileOutputStream(file)) {
                TimeUnit.MILLISECONDS.sleep(1);
                for (int i = 0 ; i < 100; i++){
                    String str = "3 wirte file test!";
                    fos.write(str.getBytes());
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println(1<<0);
        System.out.println(1<<2);
        System.out.println(1<<3);
        System.out.println(1<<4);
    }


}
