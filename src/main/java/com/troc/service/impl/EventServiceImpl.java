package com.troc.service.impl;

import com.troc.entity.Event;
import com.troc.exceptions.UserNotFoundException;
import com.troc.repository.EventRepository;
import com.troc.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event findEvent(Long id) {
        Event event= eventRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found by id:" + id));
        return event;
    }
}
