package com.dove.lol.dovelol.rpc.demo2.server.handler;

import com.dove.lol.dovelol.rpc.demo2.common.*;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.lang.reflect.Method;

/**
 * @author Dovelol
 * @date 2019/12/10 22:46
 */
public class ProviderProcessHandler extends SimpleChannelInboundHandler<RequestMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RequestMessage requestMessage) throws Exception {

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessageHeader(requestMessage.getMessageHeader());

        RequestMessageBody messageBody = requestMessage.getMessageBody();

        String methodName = messageBody.getMethodName();
        Class<?>[] parameterTypes = messageBody.getParameterTypes();
        Object[] arguments = messageBody.getArguments();
        Class<?> service = messageBody.getService();
        Object object = service.newInstance();
        Method method = object.getClass().getMethod(methodName, parameterTypes);
        Object result = method.invoke(object, arguments);

        ResponseMessageBody<Object> responseMessageBody = new ResponseMessageBody<>();
        responseMessageBody.setResult(result);
        responseMessage.setMessageBody(responseMessageBody);

        ctx.writeAndFlush(responseMessage);
    }


}

