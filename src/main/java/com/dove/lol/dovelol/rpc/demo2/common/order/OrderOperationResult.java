package com.dove.lol.dovelol.rpc.demo2.common.order;

import com.dove.lol.dovelol.rpc.demo2.common.OperationResult;
import lombok.Data;

/**
 * @author Dovelol
 */
@Data
public class OrderOperationResult<T> extends OperationResult {

    private final T result;

}
