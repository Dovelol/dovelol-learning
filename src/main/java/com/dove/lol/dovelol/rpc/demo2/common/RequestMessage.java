package com.dove.lol.dovelol.rpc.demo2.common;

/**
 * @author Dovelol
 */
public class RequestMessage extends Message<RequestMessageBody> {

    public RequestMessage() {
    }

    public RequestMessage(Long streamId, RequestMessageBody body) {
        MessageHeader messageHeader = new MessageHeader();

        messageHeader.setStreamId(streamId);

        messageHeader.setOpCode(1);

        this.setMessageHeader(messageHeader);

        this.setMessageBody(body);
    }

    @Override
    public Class getMessageBodyDecodeClass(int opcode) {
        return OperationType.fromOpCode(opcode).getOperationClazz();
    }

}
