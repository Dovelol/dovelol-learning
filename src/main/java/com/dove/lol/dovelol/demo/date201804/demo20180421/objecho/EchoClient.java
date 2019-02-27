package com.dove.lol.dovelol.demo.date201804.demo20180421.objecho;

import com.dove.lol.dovelol.demo.date201804.demo20180421.msgpack.MsgpackDecoder;
import com.dove.lol.dovelol.demo.date201804.demo20180421.msgpack.MsgpackEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author Dovelol
 * @date 2018/4/21 11:04
 */
public class EchoClient {

//    private final String host;
//
//    private final int port;
//
//    private final int sendNumber;
//
//    public EchoClient(String host, int port, int sendNumber) {
//        this.host = host;
//        this.port = port;
//        this.sendNumber = sendNumber;
//    }
//
//    public void connect() throws Exception {
//        //配置客户端NIO线程组
//        EventLoopGroup group = new NioEventLoopGroup();
//
//        try {
//            Bootstrap b = new Bootstrap();
//            b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
//                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
//                    .handler(new ChannelInitializer<SocketChannel>() {
//                        @Override
//                        protected void initChannel(SocketChannel socketChannel) throws Exception {
//                            socketChannel.pipeline().addLast("frameDecoder", new LengthFieldBasedFrameDecoder(65535, 0, 2, 0, 2));
//
//                            socketChannel.pipeline().addLast("msgpack decoder", new MsgpackDecoder());
//
//                            socketChannel.pipeline().addLast("frameEncoder", new LengthFieldPrepender(2));
//
//                            socketChannel.pipeline().addLast("msgpack encoder", new MsgpackEncoder());
//                            socketChannel.pipeline().addLast(new EchoClientHandler(sendNumber));
//                        }
//                    });
//
//            //发起异步连接操作
//            ChannelFuture f = b.connect(host, port).sync();
//
//            //等待客户端链路关闭
//            f.channel().closeFuture().sync();
//        } finally {
//            //优雅退出，释放NIO线程组
//
//            group.shutdownGracefully();
//        }
//
//    }
//
//
//    public static void main(String[] args) throws Exception {
//        new EchoClient("127.0.0.1", 8080, 5).connect();
//    }
}
