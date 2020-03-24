package com.dove.lol.dovelol.rpc.demo2.common;

import lombok.Data;

/**
 * @author Dovelol
 * @date 2019/12/10 23:05
 */
@Data
public class ResponseMessageBody<T> extends MessageBody{

    private T result;

}
