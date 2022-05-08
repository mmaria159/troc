package com.troc.service;

import com.troc.entity.Event;

import java.util.List;

public interface EventService {

    List<Event> findAllEvents();

    Event saveEvent(Event event);

    Event findEvent(Long id);
}
