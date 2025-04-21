package com.event.p1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.event.p1.entity.Event;
import com.event.p1.repository.EventRepository;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<com.event.p1.entity.Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event newEventData) {
        Event existingEvent = eventRepository.findById(id).orElse(null);
        if (existingEvent != null) {
//            existingEvent.setEventName(newEventData.getEventName());
//            existingEvent.setDate(newEventData.getDate());
//            existingEvent.setEventType(newEventData.getEventType());
            return eventRepository.save(existingEvent);
        }
        return null;
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
