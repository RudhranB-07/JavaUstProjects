package com.event.p1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.p1.entity.EventType;
import com.event.p1.service.EventTypeService;

@RestController
@RequestMapping("/eventtypes")
public class EventTypeController {
    private final EventTypeService eventTypeService;

    public EventTypeController(EventTypeService eventTypeService) {
        this.eventTypeService = eventTypeService;
    }

    @GetMapping("/all")
    public List<EventType> getAllEventTypes() {
        return eventTypeService.getAllEventTypes();
    }

    @GetMapping("/{id}")
    public EventType getEventTypeById(@PathVariable Long id) {
        return eventTypeService.getEventTypeById(id);
    }

    @PostMapping("/create")
    public EventType createEventType(@RequestBody EventType eventType) {
        return eventTypeService.saveEventType(eventType);
    }

    @PutMapping("/update/{id}")
    public EventType updateEventType(@PathVariable Long id, @RequestBody EventType newEventTypeData) {
        return eventTypeService.updateEventType(id, newEventTypeData);
    }

    @DeleteMapping("/{id}")
    public String deleteEventType(@PathVariable Long id) {
        eventTypeService.deleteEventType(id);
        return "Event type deleted successfully!";
    }
}
