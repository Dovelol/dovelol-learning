package com.dove.lol.dovelol.rpc.demo2.client.codec;

import com.dove.lol.dovelol.rpc.demo2.common.RequestMessage;
import com.dove.lol.dovelol.rpc.demo2.common.RequestMessageBody;
import com.dove.lol.dovelol.rpc.demo2.util.IdUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

public class OperationToRequestMessageEncoder extends MessageToMessageEncoder <RequestMessageBody> {

    @Override
    protected void encode(ChannelHandlerContext ctx, RequestMessageBody operation, List<Object> out) throws Exception {
          RequestMessage requestMessage = new RequestMessage(IdUtil.nextId(), operation);

          out.add(requestMessage);
     }


}
