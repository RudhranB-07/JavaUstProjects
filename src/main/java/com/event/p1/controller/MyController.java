package com.event.p1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.p1.entity.MyUser;
import com.event.p1.helper.AuthRequest;
import com.event.p1.service.MyService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/v2")
public class MyController {
	
	@Autowired
	private MyService myService;

	@GetMapping
	public String home() {
		return "Welcome home";
	}
	@GetMapping("/all")
	public List<MyUser> getAll(){
		return myService.getAll();
	}
	
	
	@GetMapping("/contact")
	@PreAuthorize("hasAnyAuthority('admin','user')")
	public String contact() {
		return "Contact us at .....";
	}
	
	
}
