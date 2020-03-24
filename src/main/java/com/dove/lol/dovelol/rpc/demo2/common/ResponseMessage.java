package com.dove.lol.dovelol.rpc.demo2.common;

/**
 * @author Dovelol
 */
public class ResponseMessage extends Message<ResponseMessageBody> {

    @Override
    public Class getMessageBodyDecodeClass(int opcode) {
        return OperationType.fromOpCode(opcode).getOperationResultClazz();
    }

}
