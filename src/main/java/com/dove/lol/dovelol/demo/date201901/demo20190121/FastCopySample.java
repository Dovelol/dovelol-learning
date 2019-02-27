package com.dove.lol.dovelol.demo.date201901.demo20190121;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Dovelol
 * @date 2019/1/21 22:46
 */
public class FastCopySample {

    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
            fastCopy("C:\\Users\\Dovelol\\Desktop\\IMG_0339.MOV", "C:\\Users\\Dovelol\\Desktop\\IMG_0339-1.MOV");
            System.out.println(System.currentTimeMillis() - start);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            long start1 = System.currentTimeMillis();
            normalCopy("C:\\Users\\Dovelol\\Desktop\\IMG_0339.MOV", "C:\\Users\\Dovelol\\Desktop\\IMG_0339-2.MOV");
            System.out.println(System.currentTimeMillis() - start1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void fastCopy(String src, String dist) throws IOException {

        /* 获得源文件的输入字节流 */
        FileInputStream fin = new FileInputStream(src);

        /* 获取输入字节流的文件通道 */
        FileChannel fcin = fin.getChannel();

        /* 获取目标文件的输出字节流 */
        FileOutputStream fout = new FileOutputStream(dist);

        /* 获取输出字节流的文件通道 */
        FileChannel fcout = fout.getChannel();

        /* 为缓冲区分配 1024 个字节 */
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true) {

        /* 从输入通道中读取数据到缓冲区中 */
            int r = fcin.read(buffer);

        /* read() 返回 -1 表示 EOF */
            if (r == -1) {
                break;
            }

        /* 切换读写 */
            buffer.flip();

        /* 把缓冲区的内容写入输出文件中 */
            fcout.write(buffer);

        /* 清空缓冲区 */
            buffer.clear();
        }
    }

    public static void normalCopy(String src, String dist) throws IOException {

        /* 获得源文件的输入字节流 */
        FileInputStream fin = new FileInputStream(src);

        /* 获取目标文件的输出字节流 */
        FileOutputStream fout = new FileOutputStream(dist);

        byte[] data = new byte[1024];

        while (fin.read(data) != -1) {
            fout.write(data);
        }

        fin.close();
        fout.close();
    }

}
