package com.ust.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProductserviceApplication {

	@GetMapping("/product")
	public String home()
	{
		return "Welcome to PS";
	}
	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}

}
