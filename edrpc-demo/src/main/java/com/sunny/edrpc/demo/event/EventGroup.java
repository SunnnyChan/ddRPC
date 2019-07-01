package com.sunny.edrpc.demo.event;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author sunnnychan@gmail.com
 * 事件组，包含多个事件
 * RPC 的触发事件是Set请求字段，多个Set 注册为一个事件组，
 * 只有当事件组所有的事件都触发，才会调用事件组绑定的时间处理器处理事件（RPC Call）.
 */
public class EventGroup {
    private String name;
    private String id;
    private EventHandler eventHandler;
    private Set<Event> eventSet = new HashSet<>();

    public EventGroup(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void addEvent(Event event) {
        this.eventSet.add(event);
    }

    public Set<Event> getEvents() {
        return this.eventSet;
    }

    public void setEvent(Event event) {
        this.eventSet.add(event);
    }
}
