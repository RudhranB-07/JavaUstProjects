package com.event.p1.controller;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.event.p1.entity.EventType;
//import com.event.p1.service.EventTypeService;
//
//@RestController
//@RequestMapping("/api/v3")
//public class EventController {
//
//    @Autowired
//    private EventTypeService eventTypesservice;
//
//    @GetMapping("/eventType")
//    public List<EventType> geteventTypes()
//    {
//        List<EventType> allevents=new ArrayList<>();
//        allevents=eventTypesservice.getalleventTypes();
//        return allevents;
//    }
//
//
//
//
//    @GetMapping("/all")
//    public List<Events> getAllEvents() {
//        return eventService.getAllEvents();
//    }
//
//    @GetMapping("/{id}")
//    public Events getEventById(@PathVariable Long id) {
//        return eventService.getEventById(id);
//    }
//
//    @PostMapping("/create")
//    public Events createEvent(@RequestBody Events event) {
//        return eventService.saveEvent(event);
//    }
//
//    @PutMapping("/update/{id}")
//    public Events updateEvent(@PathVariable Long id, @RequestBody Events newEventData) {
//        return eventService.updateEvent(id, newEventData);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteEvent(@PathVariable Long id) {
//        eventService.deleteEvent(id);
//        return "Event deleted successfully!";
//    }
//}


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.p1.entity.Event;
import com.event.p1.service.EventService;

@RestController
@RequestMapping("/Event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/all")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PostMapping("/create")
    public Event createEvent(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }

    @PutMapping("/update/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event newEventData) {
        return eventService.updateEvent(id, newEventData);
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "Event deleted successfully!";
    }
}

