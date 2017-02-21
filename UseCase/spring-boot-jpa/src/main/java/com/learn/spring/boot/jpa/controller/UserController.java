package com.learn.spring.boot.jpa.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.spring.boot.jpa.model.User;
import com.learn.spring.boot.jpa.repo.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	UserRepository repository;

	@Autowired
	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> save(@RequestBody User user) {
		repository.save(user);
		return ResponseEntity.created(URI.create("/" + user.getId())).body(user);
	}

	@GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getById(@PathVariable String userId) {
		return ResponseEntity.ok(repository.findOne(userId));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<User>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> update(@RequestBody User user) {
		repository.save(user);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable String userId) {
		repository.delete(userId);
		return ResponseEntity.ok(userId);
	}
}
