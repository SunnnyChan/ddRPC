package com.sunny.edrpc.demo.rpc;

/**
 * @author sunnnychan@gmail.com
 * RPC 注册后返回的对象，包含 Request ID（实际是事件组ID） 和 Request 的代理类，后续的 Request 方法调用都通过代理类
 */
public class EdRpc<T> {
    private T edRpcRequest;
    private String rpcId;

    public T getEdRpcRequest() {
        return edRpcRequest;
    }

    public void setEdRpcRequest(T edRpcRequest) {
        this.edRpcRequest = edRpcRequest;
    }

    public String getRpcId() {
        return rpcId;
    }

    public void setRpcId(String rpcId) {
        this.rpcId = rpcId;
    }
}
