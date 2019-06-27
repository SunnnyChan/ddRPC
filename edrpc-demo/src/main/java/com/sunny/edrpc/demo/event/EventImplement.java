package com.sunny.edrpc.demo.event;

import java.util.UUID;

public class EventImplement implements Event {
    private String name;
    private String id;
    private EventGroup eventGroup;
    private EventStatus eventStatus;

    public EventImplement(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.eventStatus = EventStatus.CREATED;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public EventGroup getEventGroup() {
        return eventGroup;
    }

    @Override
    public void setEventGroup(EventGroup eventGroup) {
        this.eventGroup = eventGroup;
    }

    @Override
    public EventStatus getEventStatus() {
        return eventStatus;
    }

    @Override
    public void setEventStatus(EventStatus eventStatus) {
        this.eventStatus = eventStatus;
    }
}
