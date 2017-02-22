package com.sapient.ACE.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.ACE.Entities.User;
import com.sapient.ACE.service.UserService;

@RestController
@RequestMapping(path="/users")
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	
	@RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    String save(@RequestBody User user) {
		userService.saveUser(user);
        return "Saved";
    }
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
    String get(@PathVariable int uid) {
    	User user=userService.getUser(uid);
        return user.toString();
    }
	
	@RequestMapping( value="/{id}",method = RequestMethod.DELETE)
    String delete(@PathVariable int userID) {
		userService.deleteUser(userID);
        return "Deleted";
    }
    

}
