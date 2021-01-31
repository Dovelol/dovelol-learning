package com.dove.lol.dovelol.demo.date202101.demo20210104;

/**
 * @author Dovelol
 * @date 2021/1/4 22:16
 */
public class ConsumerClient {


    public static void main(String[] args) {
        Properties properties = new Properties();
        // 您在控制台创建的Group ID。
        properties.put(PropertyKeyConst.GROUP_ID,"XXX");
        // AccessKey ID阿里云身份验证，在阿里云RAM控制台创建。
        properties.put(PropertyKeyConst.AccessKey,"XXX");
        // AccessKey Secret阿里云身份验证，在阿里云RAM控制台创建。
        properties.put(PropertyKeyConst.SecretKey,"XXX");
        // 设置TCP接入域名，进入消息队列RocketMQ版控制台的实例详情页面的TCP协议客户端接入点区域查看。
        properties.put(PropertyKeyConst.NAMESRV_ADDR,"XXX");
        // 顺序消息消费失败进行重试前的等待时间，单位（毫秒），取值范围: 10毫秒~30,000毫秒。
        properties.put(PropertyKeyConst.SuspendTimeMillis,"100");
        // 消息消费失败时的最大重试次数。
        properties.put(PropertyKeyConst.MaxReconsumeTimes,"20");

        // 在订阅消息前，必须调用start方法来启动Consumer，只需调用一次即可。
        OrderConsumer consumer = ONSFactory.createOrderedConsumer(properties);

        consumer.subscribe(
                // Message所属的Topic。
                "Order_global_topic",
                // 订阅指定Topic下的Tags：
                // 1. * 表示订阅所有消息。
                // 2. TagA || TagB || TagC表示订阅TagA或TagB或TagC的消息。
                "*",
                new MessageOrderListener() {
                    /**
                     * 1. 消息消费处理失败或者处理出现异常，返回OrderAction.Suspend。
                     * 2. 消息处理成功，返回OrderAction.Success。
                     */
                    @Override
                    public OrderAction consume(Message message, ConsumeOrderContext context) {
                        System.out.println(message);
                        return OrderAction.Success;
                    }
                });

        consumer.start();
    }

}
