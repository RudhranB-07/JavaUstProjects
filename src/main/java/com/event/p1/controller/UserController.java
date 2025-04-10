package com.event.p1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.p1.entity.MyUser;
import com.event.p1.helper.AuthRequest;
import com.event.p1.service.MyUserDetailsService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private AuthenticationManager am;
	
	
	
	@Autowired
	private MyUserDetailsService muds;

	@GetMapping("/about")
	public String about() {
		return "About us...";
	}
	
	
	
	@PostMapping("/login")
	public String login(@RequestBody AuthRequest ar) {
		Authentication auth = am.authenticate(new UsernamePasswordAuthenticationToken(ar.getUsername(), ar.getPassword()));
		System.out.println(auth);
		return "Login successful";
	}
	
	@PostMapping("/signup")
	public String signup(@RequestBody MyUser myUser) {
		muds.addMyUser(myUser);
		return "Signed up";
	}

}
