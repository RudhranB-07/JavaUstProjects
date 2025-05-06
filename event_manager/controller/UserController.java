package com.example.event_manager.controller;

import com.example.event_manager.entity.*;
import com.example.event_manager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private EventTypesService eventTypesService;
    @Autowired
    private EventsService eventsService;
    @Autowired
    private FoodOrderService foodOrderService;
    @Autowired
    private VendorService vendorService;

    @Autowired
    private PaymentService paymentservice;


    @GetMapping("/eventType")
    public List<EventTypes> geteventTypes()
    {
        return eventTypesService.getalleventTypes();
    }

    @GetMapping("/events")
    public List<Events> getevents(){
        List<Events> allevents=new ArrayList<>();
        allevents= eventsService.getallevents();
        return allevents;
    }

    @PostMapping("/events")
    public String createEvent(@RequestBody Events events)
    {
        eventsService.createEvent(events);
        return "Event created";
    }
    @DeleteMapping("/events/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        if (eventsService.deleteEvent(id)) {
            // If deletion is successful, return HTTP 200 (OK) with a success message.
            return ResponseEntity.ok("Event with id " + id + " was successfully deleted.");
        } else {
            // If the event doesn't exist, return HTTP 404 (Not Found) with a meaningful message.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event with id " + id + " does not exist.");
        }
    }
    @GetMapping("/foodorder")
    public List<FoodOrder> getfood(){
        return foodOrderService.getAllFoodOrders();
    }

    @GetMapping("/venuevendor")
    public List<Vendor> getallvenue(){
        return vendorService.getAllvenuevendor();
    }

    @GetMapping("/musicvendor")
    public List<Vendor> getallmusic(){
        return vendorService.getAllmusicvendor();
    }

    @GetMapping("/payment")
    public List<Payment> getpayment(){
        return paymentservice.getAllPayments();
    }




}
