package com.dove.lol.dovelol.rpc.demo1;

/**
 * TODO 类实现描述
 *
 * @author yuanzheng
 * @since 2019年11月22日 下午4:25:10
 */
public class RpcConsumer {

    public static void main(String[] args) throws Exception {
        HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String hello = service.hello("World" + i);
            System.out.println(hello);
            Thread.sleep(1000);
        }
    }

}
