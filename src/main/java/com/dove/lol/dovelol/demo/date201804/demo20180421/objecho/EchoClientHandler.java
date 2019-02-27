package com.dove.lol.dovelol.demo.date201804.demo20180421.objecho;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author Dovelol
 * @date 2018/4/21 11:14
 */
public class EchoClientHandler extends ChannelHandlerAdapter {
//
//    private final int sendNumber;
//    private int counter;
//
//    public EchoClientHandler(int sendNumber) {
//        this.sendNumber = sendNumber;
//    }
//
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) {
//        UserInfo[] infos = UserInfo();
//        for (UserInfo infoE : infos) {
//            ctx.writeAndFlush(infoE);
//        }
//        //ctx.flush();
//    }
//
//    private UserInfo[] UserInfo() {
//        UserInfo[] userInfos = new UserInfo[sendNumber];
//        UserInfo userInfo = null;
//        for (int i = 0; i < sendNumber; i++) {
//            userInfo = new UserInfo();
//            userInfo.setAge(i);
//            userInfo.setName("ABCDEFG --->" + i);
//            userInfos[i] = userInfo;
//        }
//        return userInfos;
//    }
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println("Client receive the msgpack message:" + msg);
//        //ctx.write(msg);
//    }
//
//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        ctx.flush();
//    }

}
