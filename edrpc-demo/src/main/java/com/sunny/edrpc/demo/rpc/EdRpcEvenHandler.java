package com.sunny.edrpc.demo.rpc;

import com.sunny.edrpc.demo.event.EventHandler;

/**
 * EdRPC 事件处理器
 */
public interface EdRpcEvenHandler extends EventHandler {
    String call();
}
