package com.sunny.edrpc.demo.event;

import java.util.HashMap;
/**
 * 事件管理
 */
public class EventMgt {

    private static HashMap<String, Event> events = new HashMap<>();
    private static HashMap<String, String> results = new HashMap<>();

    // 注册事件
    public static void register(Event event) {
        events.put(event.getId(), event);
        event.setEventStatus(EventStatus.REGISTERED);
    }

    // 接收到事件触发消息，遍历响应的事件组，判断是否执行事件处理程序
    public static void receive(String eventId) {
        Event event = events.get(eventId);
        event.setEventStatus(EventStatus.READY);
        EventGroup eventGroup = event.getEventGroup();
        for (Event event1 : eventGroup.getEvents()) {
            if (!event1.getEventStatus().equals(EventStatus.READY)) {
                return;
            }
        }
        // 执行事件处理程序，并缓存结果
        results.put(eventGroup.getId(), eventGroup.getEventHandler().handle());
    }

    public static String getResult(String eventGroupId) {
        return results.get(eventGroupId);
    }
}
