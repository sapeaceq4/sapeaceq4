package com.sap.ace.controller;

import com.sap.ace.models.User;
import com.sap.ace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ravdeep Singh on 2/21/2017.
 */

@RestController
public class UserController {
    @Autowired
    UserService services;

    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public ResponseEntity<User> getUsers() {
        List<User> users = services.findAll();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = services.findOne(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User userAdded = services.save(user);
        return new ResponseEntity<User>(userAdded, HttpStatus.OK);
    }
}
