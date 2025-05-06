package com.example.event_manager.service;

import com.example.event_manager.Repository.EventsRepository;
import com.example.event_manager.Repository.PaymentRepository;
import com.example.event_manager.entity.Events;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventsService {
    @Autowired
    private EventsRepository eventsRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Events> getallevents(){
        return eventsRepository.findAll();
    }

    public Optional<Events> geteventbyid(Long id )
    {
        Optional<Events> events=eventsRepository.findById(id);
        return  events;
    }

    public void createEvent(Events events){
        eventsRepository.save(events);
    }

    @Transactional
    public Boolean deleteEvent(Long id) {
        // Delete the associated payment record
        paymentRepository.deleteByEventId(id);

        // Delete the event
        if (eventsRepository.existsById(id)) {
            eventsRepository.deleteById(id);
            return true;
        } else {
            System.out.println("Event with id " + id + " does not exist.");
            return false;
        }
    }



}
