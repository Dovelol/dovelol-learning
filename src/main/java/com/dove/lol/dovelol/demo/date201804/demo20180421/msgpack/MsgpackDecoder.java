package com.dove.lol.dovelol.demo.date201804.demo20180421.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.nio.ByteBuffer;
import java.util.List;

/**
 * @author Dovelol
 * @date 2018/4/21 13:11
 */
public class MsgpackDecoder extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        final byte[] array;
        final int length = byteBuf.readableBytes();
        array = new byte[length];
        byteBuf.getBytes(byteBuf.readerIndex(), array, 0, length);

        MessagePack messagePack = new MessagePack();
        list.add(messagePack.read(array));
    }
}
