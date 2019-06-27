package com.sunny.edrpc.demo.test;

import com.sunny.edrpc.demo.event.Event;
import com.sunny.edrpc.demo.event.EventImplement;
import com.sunny.edrpc.demo.event.EventMgt;
import com.sunny.edrpc.demo.rpc.EdRpcRequest;

import java.util.HashSet;
import java.util.Set;

public class TestRequest implements EdRpcRequest {
    private int id;
    private String name;
    private Event requestFieldsNameSetEvent;
    private Event requestFieldsIdSetEvent;

    public TestRequest() {
        // 生产 Request 相关的事件，组要是 对 Request 赋值
        requestFieldsNameSetEvent = new EventImplement("Event-setName");
        requestFieldsIdSetEvent = new EventImplement("Event-idName");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        // 触发 ID 赋值事件，通知 ID 字段数据已准备好
        EventMgt.receive(requestFieldsIdSetEvent.getId());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        EventMgt.receive(requestFieldsNameSetEvent.getId());
    }

    public Set<Event> getEvents() {
        Set<Event> events = new HashSet<>();
        events.add(requestFieldsIdSetEvent);
        events.add(requestFieldsNameSetEvent);
        return events;
    }
}
