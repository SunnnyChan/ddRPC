package com.sunny.edrpc.demo.event;

/**
 * @author sunnnychan@gmail.com
 * 事件接口
 */

public interface Event {
    String getName();

    String getId();

    void setEventStatus(EventStatus eventStatus);

    EventStatus getEventStatus();

    void setEventGroup(EventGroup eventGroup);

    EventGroup getEventGroup();
}
