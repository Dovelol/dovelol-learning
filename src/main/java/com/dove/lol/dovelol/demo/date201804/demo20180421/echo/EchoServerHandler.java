package com.dove.lol.dovelol.demo.date201804.demo20180421.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author Dovelol
 * @date 2018/4/21 10:47
 */
public class EchoServerHandler extends ChannelHandlerAdapter {

//    int counter = 0;
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        String body = (String) msg;
//
//        System.out.println("This is " + ++counter + " times receive client: [" + body + "]");
//
//        body += "$_";
//
//        ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
//
//        ctx.writeAndFlush(echo);
//
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        ctx.close();
//    }
}
