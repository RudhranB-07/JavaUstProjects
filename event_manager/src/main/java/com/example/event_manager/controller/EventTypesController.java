package com.example.event_manager.controller;

import com.example.event_manager.entity.EventTypes;
import com.example.event_manager.service.EventTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventType")
public class EventTypesController {

    @Autowired
    public EventTypesService eventTypesService;

    @GetMapping
    public ResponseEntity<List<EventTypes>> getalleventtypes() {
        List<EventTypes> eventTypes = eventTypesService.getalleventTypes();
        return ResponseEntity.ok().body(eventTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventTypes> geteventtypebyid(@PathVariable Long id) {
        Optional<EventTypes> eventTypes = eventTypesService.geteventTypebyId(id);
        return ResponseEntity.ok().body(eventTypes.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEventTypes(@PathVariable Long id) {
        if (eventTypesService.deleteeventType(id)) {
            // If deletion is successful, return HTTP 200 (OK) with a success message.
            return ResponseEntity.ok("Event with id " + id + " was successfully deleted.");
        } else {
            // If the event doesn't exist, return HTTP 404 (Not Found) with a meaningful message.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event with id " + id + " does not exist.");

        }
    }

    @PostMapping
    public ResponseEntity<String> createEventType(@RequestBody EventTypes eventTypes)
    {
        eventTypesService.createeventtype(eventTypes);
        return  ResponseEntity.ok().body("Event Type Created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventTypes> updateEventTypePrice(@PathVariable Long id, @RequestBody EventTypes updatedEventType) {
        EventTypes eventType = eventTypesService.updateEventTypePrice(id, updatedEventType);
        return ResponseEntity.ok(eventType);
    }

}
