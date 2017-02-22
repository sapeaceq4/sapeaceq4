package com.sapient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.sapient.domain.User;
import com.sapient.domain.dto.UserRequest;
import com.sapient.service.IRequestsHandler;
import com.sapient.util.DTOToPOJOConverter;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	IRequestsHandler<User, Integer> requestsHandler;

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserRequest> create(@RequestBody UserRequest userRequest) {
		User user = DTOToPOJOConverter.getUserFromUserRequest(userRequest);
		user = requestsHandler.create(user);
		userRequest = DTOToPOJOConverter.getUserRequestFromUser(user);
		return new ResponseEntity<UserRequest>(userRequest, HttpStatus.CREATED);
	}

	@GetMapping(value="/{userId}")
	public ResponseEntity<User> getByUserId(@PathVariable("userId") int userId) {
		User user = requestsHandler.getOne(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Iterable<User>> getAllUsers() {
		Iterable<User> users = requestsHandler.getAll();
		return new ResponseEntity<Iterable<User>>(users, HttpStatus.OK);
	}

	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserRequest> update(@RequestBody UserRequest userRequest) {
		User user = DTOToPOJOConverter.getUserFromUserRequest(userRequest);
		user = requestsHandler.update(user);
		userRequest = DTOToPOJOConverter.getUserRequestFromUser(user);
		return new ResponseEntity<UserRequest>(userRequest, HttpStatus.OK);
	}

	@DeleteMapping(value="/{userId}")
	public ResponseEntity<String> delete(@PathVariable("userId") int userId) {
		requestsHandler.delete(userId);
		String response = "User #"+userId+" deleted successfully";
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}