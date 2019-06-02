package com.dove.lol.dovelol.demo.date201906.demo20190602;

import org.apache.catalina.util.SessionIdGeneratorBase;

/**
 * @author Dovelol
 * @date 2019/6/2 9:35
 */
public class StandardSessionIdGeneratorDemo  extends SessionIdGeneratorBase {

    @Override
    public String generateSessionId(String route) {

        byte random[] = new byte[16];
        int sessionIdLength = getSessionIdLength();

        // Render the result as a String of hexadecimal digits
        // Start with enough space for sessionIdLength and medium route size
        StringBuilder buffer = new StringBuilder(2 * sessionIdLength + 20);

        int resultLenBytes = 0;

        while (resultLenBytes < sessionIdLength) {
            getRandomBytes(random);
            for (int j = 0;
                 j < random.length && resultLenBytes < sessionIdLength;
                 j++) {
                byte b1 = (byte) ((random[j] & 0xf0) >> 4);
                byte b2 = (byte) (random[j] & 0x0f);
                if (b1 < 10)
                    buffer.append((char) ('0' + b1));
                else
                    buffer.append((char) ('A' + (b1 - 10)));
                if (b2 < 10)
                    buffer.append((char) ('0' + b2));
                else
                    buffer.append((char) ('A' + (b2 - 10)));
                resultLenBytes++;
            }
        }

        if (route != null && route.length() > 0) {
            buffer.append('.').append(route);
        } else {
            String jvmRoute = getJvmRoute();
            if (jvmRoute != null && jvmRoute.length() > 0) {
                buffer.append('.').append(jvmRoute);
            }
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        StandardSessionIdGeneratorDemo demo = new StandardSessionIdGeneratorDemo();
        String test = demo.generateSessionId("test");
        System.out.println(test);
    }


}
