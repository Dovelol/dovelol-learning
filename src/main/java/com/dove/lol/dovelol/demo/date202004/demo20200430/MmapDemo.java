package com.dove.lol.dovelol.demo.date202004.demo20200430;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Dovelol
 * @date 2020/4/30 20:56
 */
public class MmapDemo {


    public static void main(String[] args) throws IOException {
        File file = new File("E:\\xm\\rocketmq\\test");
        if(!file.exists()){
            file.createNewFile();
        }

        String message = "message111";

        FileChannel fileChannel = new RandomAccessFile(file,"rw").getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
        byteBuffer.put(message.getBytes());

        byteBuffer.flip();

        fileChannel.write(byteBuffer);

       fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 1024*1024*1024);

        fileChannel.force(false);
        System.out.println(fileChannel.size());


    }

}
