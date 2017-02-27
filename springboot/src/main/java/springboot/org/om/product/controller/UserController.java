package springboot.org.om.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot.org.om.product.entity.User;
import springboot.org.om.product.services.GenericService;

@RestController
public class UserController 
{
	@Autowired
	private GenericService<User,Long> userService;
	
	 @RequestMapping(value = "/users", method = RequestMethod.GET)
	 public ResponseEntity<List<User>> getUsers() 
	 {
		 List<User> users = userService.readAll();
		 return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	 public ResponseEntity<User> getUsersId(@PathVariable long id) 
	 {
		 User user = userService.readById(id);
		 return new ResponseEntity<User>(user, HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/users", method = RequestMethod.POST,headers="Accept=application/json")
	 public ResponseEntity<User> createUser(@RequestBody User user) 
	 {
		 User newUser =  userService.create(user);
		 return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
	 }
	 
	 @RequestMapping(value = "/users/{id}" , method = RequestMethod.DELETE)
	 public ResponseEntity<String> deleteUserById(@PathVariable long id) 
	 {
		 userService.deleteById(id);
		 return new ResponseEntity<String>("{\"message\": \"User has been deleted.\"}",HttpStatus.OK);
	 }
}
