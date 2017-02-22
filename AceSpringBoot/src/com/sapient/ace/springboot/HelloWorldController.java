package com.sapient.ace.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@GetMapping
	public String helloWorld() {
		return "Mohit Kumar says, \"Hello World!!!\"";
	}

}
