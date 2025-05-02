package com.example.event_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.event_manager.entity.UserDetails;
import com.example.event_manager.helper.Helper;
import com.example.event_manager.service.MyUserDetailsService;

@RestController
@RequestMapping("/credentials")
public class UserController {

	@Autowired
	private AuthenticationManager am;
	
	
	
	@Autowired
	private MyUserDetailsService muds;

	
	@GetMapping("/home")
	public String home (){
		return "Welcome home";
	}
	
	@PostMapping("/signup")
	public String signup(@RequestBody UserDetails myUser) {
		muds.addMyUser(myUser);
		return "Signed up";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Helper ar) {
		Authentication auth = am.authenticate(new UsernamePasswordAuthenticationToken(ar.getEmail(), ar.getPassword()));
		System.out.println(auth);
		return "Login successful";
	}



}
