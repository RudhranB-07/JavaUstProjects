package com.example.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.event.entity.Guest;
import com.example.event.service.GuestService;

@RestController
@RequestMapping("/api/guest")
public class GuestController {
    @Autowired
    private GuestService guestService;

    @PostMapping("/register")
    public ResponseEntity<Guest> registerGuest(@RequestBody Guest guest) {
        return ResponseEntity.ok(guestService.saveGuest(guest));
    }

    @GetMapping("/{email}")
    public ResponseEntity<Guest> getGuestByEmail(@PathVariable String email) {
        return ResponseEntity.ok(guestService.findGuestByEmail(email));
    }
}
