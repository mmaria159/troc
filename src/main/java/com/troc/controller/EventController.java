package com.troc.controller;

import com.troc.entity.Event;
import com.troc.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Event>> findAllEvents() {
        return new ResponseEntity<>(eventService.findAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public Event findEvent(@PathVariable Long id) {
        return eventService.findEvent(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
    public ResponseEntity<Event> saveEvent(@RequestBody Event event) {
        return new ResponseEntity<>(eventService.saveEvent(event), HttpStatus.OK);
    }
}
