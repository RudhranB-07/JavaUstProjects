package com.example.event_manager.service;

import com.example.event_manager.Repository.EventTypesRepository;
import com.example.event_manager.entity.EventTypes;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventTypesService {
    @Autowired
    private EventTypesRepository eventTyperepository;


    public List<EventTypes> getalleventTypes()
    {
        return eventTyperepository.findAll();
    }

    public Optional<EventTypes> geteventTypebyId(Long id)
    {
        return eventTyperepository.findById(id);
    }

    public Boolean deleteeventType(Long id)
    {
        if (eventTyperepository.existsById(id)) {
            eventTyperepository.deleteById(id);
            return true;
        } else {
            System.out.println("Event with id " + id + " does not exist.");
            return false;
        }
    }

    public void createeventtype(EventTypes eventTypes)
    {
        eventTyperepository.save(eventTypes);
    }

    @Transactional
    public EventTypes updateEventTypePrice(Long id, EventTypes updatedEventType) {
        // Find the existing EventType by ID
        EventTypes existingEventType = eventTyperepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EventType not found with id: " + id));

        // Update the price
        existingEventType.setPrice(updatedEventType.getPrice());

        // Save and return the updated EventType
        return eventTyperepository.save(existingEventType);
    }

}
