package com.dove.lol.dovelol.demo.date201804.demo20180412;

import com.dove.lol.dovelol.demo.date201804.demo20180421.objecho.UserInfo;
import io.netty.util.internal.PlatformDependent;
import org.msgpack.MessagePack;
import org.msgpack.packer.Packer;
import org.msgpack.template.Template;
import org.msgpack.unpacker.Unpacker;

import java.io.IOException;

/**
 * @author Dovelol
 * @date 2018/4/12 22:09
 */
public class Test {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));

        System.out.println(((82765.34 * 2.1489 - 170000 * 1.05) * 0.8 + 170000 * 1.05) * 15 / 17);

        System.out.println(PlatformDependent.isWindows());

        MessagePack pack = new MessagePack();
        UserInfo userInfo = new UserInfo();
        userInfo.setName("dove");
        userInfo.setAge(20);
        try {
            System.out.println("单个对象使用Msgpack");
            System.out.println("序列化前: " + userInfo.toString());
            // 序列化
            byte[] bytes = pack.write(userInfo);
            // 反序列化
            UserInfo s = pack.read(bytes, UserInfo.class);
            System.out.println("反序列化: " + s.toString());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        System.out.println();

    }

}
