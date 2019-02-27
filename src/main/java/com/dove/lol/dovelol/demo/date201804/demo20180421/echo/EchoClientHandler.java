package com.dove.lol.dovelol.demo.date201804.demo20180421.echo;

import com.dove.lol.dovelol.demo.date201804.demo20180421.objecho.UserInfo;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author Dovelol
 * @date 2018/4/21 11:14
 */
public class EchoClientHandler extends ChannelHandlerAdapter {

//    private int counter;
//
//    static final String ECHO_REQ = "Hi, Dovelol. Welcome to Netty.";
//
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//
//        for (int i = 0; i < 100; i++) {
//            ctx.writeAndFlush(Unpooled.copiedBuffer((ECHO_REQ+(i+1)+"$_").getBytes()));
//        }
//
//    }
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println("This is " + ++counter + " times receive server: [" + msg + "]");
//    }
//
//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        ctx.flush();
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        ctx.close();
//    }
}
