package com.sunny.edrpc.demo.event;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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

    public void setEventSet(Set<Event> eventSet) {
        this.eventSet = eventSet;
    }
}
