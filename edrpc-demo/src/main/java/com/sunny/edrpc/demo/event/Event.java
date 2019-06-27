package com.sunny.edrpc.demo.event;

/**
 * 事件接口
 */

public interface Event {

    String getId();

    void setEventStatus(EventStatus eventStatus);

    EventStatus getEventStatus();

    void setEventGroup(EventGroup eventGroup);

    EventGroup getEventGroup();
}
