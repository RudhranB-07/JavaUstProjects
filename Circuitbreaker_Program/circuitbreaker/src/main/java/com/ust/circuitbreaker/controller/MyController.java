package com.ust.circuitbreaker.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
public class MyController {
	@Autowired
	RestTemplate rt;

	@GetMapping
	@CircuitBreaker(name = "jag", fallbackMethod = "fallbackMethod")
	public String home() {
		String response = rt.getForObject("http://localhost:8081/product", String.class);
		return "Hello, we got reponse from product api as : "+response;
	}
	
	
	
	public String fallbackMethod(Throwable throwable)
	{
		return "This is fallback method";
	}
	
}

