package com.example.event_manager.controller;

import com.example.event_manager.entity.Events;
import com.example.event_manager.service.EventsService;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/event")
public class EventsController {
    @Autowired
    public EventsService eventsService;

    @GetMapping()
    public ResponseEntity<List<Events>> getallevent() {
        List<Events> events = eventsService.getallevents();
        return ResponseEntity.ok().body(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Events> geteventbyId(@PathVariable Long id) {
        Optional<Events> event = eventsService.geteventbyid(id);
        return ResponseEntity.ok().body(event.get());
    }

    @PostMapping
    public ResponseEntity<String> createevent(@RequestBody Events events) {
        eventsService.createEvent(events);
        return ResponseEntity.ok("Event Created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        if (eventsService.deleteEvent(id)) {
            // If deletion is successful, return HTTP 200 (OK) with a success message.
            return ResponseEntity.ok("Event with id " + id + " was successfully deleted.");
        } else {
            // If the event doesn't exist, return HTTP 404 (Not Found) with a meaningful message.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event with id " + id + " does not exist.");

        }
    }
}
