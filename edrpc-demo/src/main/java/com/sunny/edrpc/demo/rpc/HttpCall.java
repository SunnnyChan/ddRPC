package com.sunny.edrpc.demo.rpc;

import com.sunny.edrpc.demo.event.EventHandler;

import java.util.HashMap;

/**
 * @author sunnnychan@gmail.com
 * 基于HTTP协议的RPC，实现了事件处理接口
 */

public class HttpCall implements EventHandler {
    private final int port = 8081;
    private final String host = "127.0.0.1";

    private HashMap<String, String> cookies = new HashMap<>();
    private HashMap<String, String> header = new HashMap<>();

    public HttpCall(EdRpcRequest rpcRequest, HashMap<String, String> cookies, HashMap<String, String> header) {
        this.cookies = cookies;
        this.header = header;
    }

    public HashMap<String, String> getCookies() {
        return cookies;
    }

    public void setCookies(HashMap<String, String> cookies) {
        this.cookies = cookies;
    }

    public HashMap<String, String> getHeader() {
        return header;
    }

    public void setHeader(HashMap<String, String> header) {
        this.header = header;
    }

    // 事件处理
    @Override
    public String handle() {
        return "edRPC call successfully";
    }

}
