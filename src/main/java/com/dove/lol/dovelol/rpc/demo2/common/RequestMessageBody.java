package com.dove.lol.dovelol.rpc.demo2.common;

import lombok.Data;

/**
 * @author Dovelol
 * @date 2019/12/10 22:56
 */
@Data
public class RequestMessageBody extends MessageBody  {

    private String methodName;

    private Class<?>[] parameterTypes;

    private Object[] arguments;

    private Class<?> service;

}
