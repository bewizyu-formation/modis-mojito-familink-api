package org.gestion.web.controller;

import java.util.List;

import org.gestion.entite.User;
import org.gestion.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class RestUserController {

	@Autowired
	@Qualifier("userServiceRepository")
	private IUserService userServiceRepository;
	
	// ********** GET USER ********** //
	
	@RequestMapping(path = "/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<User> getListWithRepository() {
		return userServiceRepository.getUsers();
	}
	
	

	// ********** CREATE USER ********** //

	@RequestMapping(path = "/", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	public User createUser(@RequestBody User newUser) {
		return userServiceRepository.create(newUser);
	}
	
	// ****** UPDATE USER PASSWORD ***** //
	
	@RequestMapping(path = "/", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public void updateUser(@RequestBody User userUpdated) {
		userServiceRepository.update(userUpdated);
	}
	
	// ******** AUTHENTICATION ******* //
	
	@RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	public void authenticateUser(@RequestBody User user) {
		 
	}
	
	
	

}
