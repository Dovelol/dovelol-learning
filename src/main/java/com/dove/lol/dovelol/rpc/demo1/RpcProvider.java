package com.dove.lol.dovelol.rpc.demo1;

/**
 * TODO 类实现描述
 *
 * @author yuanzheng
 * @since 2019年11月22日 下午4:24:52
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }

}
