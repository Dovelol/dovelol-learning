package com.dove.lol.dovelol.demo.date201903.demo20190317;

/**
 * @author Dovelol
 * @date 2019/3/17 15:32
 */
public class BridgeMethodDemo {

    public static void main(String[] args) {
        BridgeMethodDemo demo = new SubBridgeMethodDemo();
        Number compute = demo.compute(100d);
        System.out.println(compute);
    }

    public Number compute(Double d) {
        return 100 * d;
    }


}
