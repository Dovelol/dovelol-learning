package com.dove.lol.dovelol.demo.date202101.demo20210104;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.aliyun.openservices.ons.api.SendResult;
import com.aliyun.openservices.ons.api.order.OrderProducer;

import java.util.Date;
import java.util.Properties;

/**
 * @author Dovelol
 * @date 2021/1/4 22:19
 */
public class ProcuderClient {
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
        OrderProducer producer = ONSFactory.createOrderProducer(properties);
        // 在发送消息前，必须调用start方法来启动Producer，只需调用一次即可。
        producer.start();
        for (int i = 0; i < 1000; i++) {
            String orderId = "biz_" + i % 10;
            Message msg = new Message(
                    // Message所属的Topic。
                    "Order_global_topic",
                    // Message Tag，可理解为Gmail中的标签，对消息进行再归类，方便Consumer指定过滤条件在消息队列RocketMQ版的服务器过滤。
                    "TagA",
                    // Message Body，可以是任何二进制形式的数据，消息队列RocketMQ版不做任何干预，需要Producer与Consumer协商好一致的序列化和反序列化方式。
                    "send order global msg".getBytes()
            );
            // 设置代表消息的业务关键属性，请尽可能全局唯一。
            // 以方便您在无法正常收到消息情况下，可通过控制台查询消息并补发。
            // 注意：不设置也不会影响消息正常收发。
            msg.setKey(orderId);
            // 分区顺序消息中区分不同分区的关键字段，Sharding Key与普通消息的key是完全不同的概念。
            // 全局顺序消息，该字段可以设置为任意非空字符串。
            String shardingKey = String.valueOf(orderId);
            try {
                SendResult sendResult = producer.send(msg, shardingKey);
                // 发送消息，只要不抛异常就是成功。
                if (sendResult != null) {
                    System.out.println(new Date() + " Send mq message success. Topic is:" + msg.getTopic() + " msgId is: " + sendResult.getMessageId());
                }
            }
            catch (Exception e) {
                // 消息发送失败，需要进行重试处理，可重新发送这条消息或持久化这条数据进行补偿处理。
                System.out.println(new Date() + " Send mq message failed. Topic is:" + msg.getTopic());
                e.printStackTrace();
            }
        }
        // 在应用退出前，销毁Producer对象。
        // 注意：如果不销毁也没有问题。
        producer.shutdown();
    }
}
