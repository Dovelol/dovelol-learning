package com.dove.lol.dovelol.rpc.demo2.common;

/**
 * @author Dovelol
 */
public abstract class Operation extends MessageBody {

    public abstract OperationResult execute(RequestMessage requestMessage);

}
