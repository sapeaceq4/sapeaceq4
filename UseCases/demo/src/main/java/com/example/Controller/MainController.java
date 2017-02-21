package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Product;
import com.example.Entity.User;
import com.example.Repository.Repo;

@RestController
public class MainController {

	@Autowired
	Repo repo;
	
	@GetMapping
	public String main() {
		return "Hello :)";
	}
	
	@RequestMapping("/createUser")
	 public String create(User user) {
		
	     repo.saveUser(user);
		return "Congrats User has been created";
	 }
	
	@RequestMapping("/createProduct")
	 public String createProduct(Product product) {
		
	    repo.saveProduct(product);
		return "Congrats Product has been created";
	 }
	
	
	
}
