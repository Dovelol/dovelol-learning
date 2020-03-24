package com.dove.lol.dovelol.rpc.demo2;

import com.dove.lol.dovelol.rpc.demo2.client.codec.OperationToRequestMessageEncoder;
import com.dove.lol.dovelol.rpc.demo2.common.RequestMessage;
import com.dove.lol.dovelol.rpc.demo2.common.RequestMessageBody;
import com.dove.lol.dovelol.rpc.demo2.server.codec.OrderFrameDecoder;
import com.dove.lol.dovelol.rpc.demo2.server.codec.OrderFrameEncoder;
import com.dove.lol.dovelol.rpc.demo2.server.codec.OrderProtocolDecoder;
import com.dove.lol.dovelol.rpc.demo2.server.codec.OrderProtocolEncoder;
import com.dove.lol.dovelol.rpc.demo2.util.IdUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * TODO 类实现描述
 *
 * @author yuanzheng
 * @since 2019年11月22日 下午4:25:10
 */
public class RpcConsumer {

    public static void main(String[] args) throws Exception {
//        HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            String hello = service.hello("World" + i);
//            System.out.println(hello);
//            Thread.sleep(1000);
//        }

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);

        bootstrap.group(new NioEventLoopGroup());

        bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new OrderFrameDecoder());
                pipeline.addLast(new OrderFrameEncoder());
                pipeline.addLast(new OrderProtocolEncoder());
                pipeline.addLast(new OrderProtocolDecoder());

                pipeline.addLast(new OperationToRequestMessageEncoder());
                pipeline.addLast(new LoggingHandler(LogLevel.INFO));
            }
        });

        ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 1234);

        channelFuture.sync();

        RequestMessageBody messageBody =  new RequestMessageBody();
        messageBody.setArguments(new Object[]{});
        messageBody.setMethodName("abc");
        messageBody.setParameterTypes(new Class[]{});
        messageBody.setService(HelloService.class);


        RequestMessage requestMessage = new RequestMessage(IdUtil.nextId(),messageBody);

        channelFuture.channel().writeAndFlush(requestMessage);

        channelFuture.channel().closeFuture().sync();

    }

}
