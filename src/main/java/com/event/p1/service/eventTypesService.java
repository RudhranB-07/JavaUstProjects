package com.event.p1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.p1.entity.eventTypes;
import com.event.p1.repository.eventTypesRepository;

@Service
public class eventTypesService {
    @Autowired
    private eventTypesRepository eventTyperepository;


    public List<eventTypes> getalleventTypes()
    {
        return eventTyperepository.findAll();
    }
}
