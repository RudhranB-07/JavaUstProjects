package com.event.p1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.event.p1.entity.EventType;
import com.event.p1.repository.EventTypeRepository;

@Service
public class EventTypeService {
    private final EventTypeRepository eventTypeRepository;

    public EventTypeService(EventTypeRepository eventTypeRepository) {
        this.eventTypeRepository = eventTypeRepository;
    }

    public List<EventType> getAllEventTypes() {
        return eventTypeRepository.findAll();
    }

    public EventType getEventTypeById(Long id) {
        return eventTypeRepository.findById(id).orElse(null);
    }

    public EventType saveEventType(EventType eventType) {
        return eventTypeRepository.save(eventType);
    }

    public EventType updateEventType(Long id, EventType newEventTypeData) {
        EventType existingEventType = eventTypeRepository.findById(id).orElse(null);
        if (existingEventType != null) {
            existingEventType.setName(newEventTypeData.getName());
            existingEventType.setPrice(newEventTypeData.getPrice());
            return eventTypeRepository.save(existingEventType);
        }
        return null;
    }

    public void deleteEventType(Long id) {
        eventTypeRepository.deleteById(id);
    }
}
