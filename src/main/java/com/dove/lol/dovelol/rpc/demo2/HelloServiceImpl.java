package com.dove.lol.dovelol.rpc.demo2;

/**
 * TODO 类实现描述
 *
 * @author yuanzheng
 * @since 2019年11月22日 下午4:24:31
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "Hello " + name;
    }

}
