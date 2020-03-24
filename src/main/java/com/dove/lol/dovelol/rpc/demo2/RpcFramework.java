package com.dove.lol.dovelol.rpc.demo2;

import com.dove.lol.dovelol.demo.date201712.demo20171217.request.Request;
import com.dove.lol.dovelol.rpc.demo2.client.codec.OperationToRequestMessageEncoder;
import com.dove.lol.dovelol.rpc.demo2.client.handler.dispatcher.OperationResultFuture;
import com.dove.lol.dovelol.rpc.demo2.common.OperationResult;
import com.dove.lol.dovelol.rpc.demo2.common.RequestMessage;
import com.dove.lol.dovelol.rpc.demo2.common.RequestMessageBody;
import com.dove.lol.dovelol.rpc.demo2.common.order.OrderOperation;
import com.dove.lol.dovelol.rpc.demo2.server.codec.OrderFrameDecoder;
import com.dove.lol.dovelol.rpc.demo2.server.codec.OrderFrameEncoder;
import com.dove.lol.dovelol.rpc.demo2.server.codec.OrderProtocolDecoder;
import com.dove.lol.dovelol.rpc.demo2.server.codec.OrderProtocolEncoder;
import com.dove.lol.dovelol.rpc.demo2.server.handler.ProviderProcessHandler;
import com.dove.lol.dovelol.rpc.demo2.util.IdUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioChannelOption;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TODO 类实现描述
 *
 * @author yuanzheng
 * @since 2019年11月22日 下午4:23:10
 */
public class RpcFramework {

    /**
     * 暴露服务
     *
     * @param port 服务端口
     * @throws Exception
     */
    public static void export(int port) throws Exception {
        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port " + port);
        }
        System.out.println("Export service on port " + port);

        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workGroup = new NioEventLoopGroup(2);

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workGroup);
        serverBootstrap.channel(NioServerSocketChannel.class);
//        serverBootstrap.option(NioChannelOption.SO_BACKLOG, 1024);
//        serverBootstrap.childOption(NioChannelOption.TCP_NODELAY, true);
        serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));

        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {

                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new OrderFrameDecoder());
                pipeline.addLast(new OrderFrameEncoder());
                pipeline.addLast(new OrderProtocolEncoder());
                pipeline.addLast(new OrderProtocolDecoder());

                pipeline.addLast(new LoggingHandler(LogLevel.INFO));

                pipeline.addLast(new ProviderProcessHandler());
            }
        });

        ChannelFuture channelFuture = serverBootstrap.bind(port).sync();

        channelFuture.channel().closeFuture().get();
    }

    /**
     * 引用服务
     *
     * @param <T> 接口泛型
     * @param interfaceClass 接口类型
     * @param host 服务器主机名
     * @param port 服务器端口
     * @return 远程服务
     * @throws Exception
     */
    public static <T> T refer(final Class<T> interfaceClass, final String host, final int port) throws Exception {
        if (interfaceClass == null) {
            throw new IllegalArgumentException("Interface class == null");
        }
        if (!interfaceClass.isInterface()) {
            throw new IllegalArgumentException("The " + interfaceClass.getName() + " must be interface class!");
        }
        if (host == null || host.length() == 0) {
            throw new IllegalArgumentException("Host == null!");
        }
        if (port <= 0 || port > 65535) {
            throw new IllegalArgumentException("Invalid port " + port);
        }
        System.out.println("Get remote service " + interfaceClass.getName() + " from server " + host + ":" + port);
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[] { interfaceClass },
                (proxy, method, arguments) -> {

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

                    ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", port);

                    channelFuture.sync();

                    RequestMessageBody messageBody =  new RequestMessageBody();
                    messageBody.setArguments(arguments);
                    messageBody.setMethodName(method.getName());
                    messageBody.setParameterTypes(method.getParameterTypes());
                    messageBody.setService(interfaceClass);


                    RequestMessage requestMessage = new RequestMessage(IdUtil.nextId(),messageBody);

                    channelFuture.channel().writeAndFlush(requestMessage);

                    //channelFuture.channel().closeFuture().sync();

                    return null;

                });
    }

}
