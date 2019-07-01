package com.sunny.edrpc.demo.rpc;

import com.sunny.edrpc.demo.event.EventHandler;

/**
 * @author sunnnychan@gmail.com
 * EdRPC 事件处理器接口
 */
public interface EdRpcEventHandler extends EventHandler {
    String call();
}
