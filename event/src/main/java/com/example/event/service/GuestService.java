package com.example.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.event.entity.Guest;
import com.example.event.repository.GuestRepository;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;

    public Guest saveGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest findGuestByEmail(String email) {
        return guestRepository.findByEmail(email);
    }
}
