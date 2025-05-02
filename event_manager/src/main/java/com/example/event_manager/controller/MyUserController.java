package com.example.event_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.event_manager.entity.UserDetails;
import com.example.event_manager.service.MyUserService;

@RestController
@RequestMapping("/user")
public class MyUserController {
	
	@Autowired
	private AuthenticationManager am;
	@Autowired
	private MyUserService userService;


    
    @GetMapping("/all")
    public List<UserDetails> getAll(){
    	return userService.getAll();
    }
    
    @GetMapping("/{email}")
    public ResponseEntity<UserDetails> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update User
    @PutMapping("/update/{email}")
    public ResponseEntity<UserDetails> updateUser(@PathVariable String email, @RequestBody UserDetails updatedUser) {
        return userService.updateUser(email, updatedUser)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete User
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email) {
        return userService.deleteUser(email) ? ResponseEntity.noContent().build()
                                                    : ResponseEntity.notFound().build();
    }
}
    


