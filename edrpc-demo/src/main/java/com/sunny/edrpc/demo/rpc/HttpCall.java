package com.sunny.edrpc.demo.rpc;

import com.sunny.edrpc.demo.event.*;
import java.util.HashMap;

/**
 * 一次基于Http协议的RPC的处理
 */

public class HttpCall implements EventHandler {
    private final int port = 8081;
    private final String host = "127.0.0.1";

    private HashMap<String, String> cookies = new HashMap<>();
    private HashMap<String, String> header = new HashMap<>();

    private EventGroup eventGroup;

    public HttpCall(EdRpcRequest rpcRequest, HashMap<String, String> cookies, HashMap<String, String> header) {
        this.cookies = cookies;
        this.header = header;

        // 一次 RPC 的触发是由一组请求数据的准备事件触发的
        this.eventGroup = new EventGroup(this);
        this.eventGroup.setEventSet(rpcRequest.getEvents());
        for (Event event : rpcRequest.getEvents()) {
            EventMgt.register(event);
            event.setEventGroup(this.eventGroup);
        }
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

    public String getResult() {
        return EventMgt.getResult(this.eventGroup.getId());
    }

    // 事件处理
    @Override
    public String handle() {
        return "edRPC call successfully";
    }

}
