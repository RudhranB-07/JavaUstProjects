package com.event.p1.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.p1.entity.eventTypes;
import com.event.p1.service.eventTypesService;

@RestController
@RequestMapping("/api/v3")
public class EventController {

    @Autowired
    private eventTypesService eventTypesservice;

    @GetMapping("/eventType")
    public List<eventTypes> geteventTypes()
    {
        List<eventTypes> allevents=new ArrayList<>();
        allevents=eventTypesservice.getalleventTypes();
        return allevents;
    }
}
