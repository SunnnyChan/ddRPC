package com.sunny.edrpc.demo.rpc;

import com.sunny.edrpc.demo.event.Event;

import java.util.Set;

public interface EdRpcRequest {
    Set<Event> getEvents();
}
