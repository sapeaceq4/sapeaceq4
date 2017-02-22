package com.sapient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestHello {
	
	@GetMapping
	public String helloGb() {
		return "Hi There Dinesh!!!";
	}
}
