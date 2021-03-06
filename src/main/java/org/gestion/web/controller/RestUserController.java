package org.gestion.web.controller;

import java.util.List;

import org.gestion.entite.User;
import org.gestion.exceptions.FunctionalException;
import org.gestion.services.IUserService;
import org.gestion.utils.Tokens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class RestUserController extends AbstractRestController{

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

	@RequestMapping(path = "/create", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	public User createUser(@RequestBody User newUser) throws Exception {
		try {
			return userServiceRepository.create(newUser);
		} catch (Exception e) {
			throw e;
		}
	}
	
	// ****** UPDATE USER PASSWORD ***** //
	
	@RequestMapping(path = "/", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public void updateUser(@RequestBody User userUpdated) {
		userServiceRepository.update(userUpdated);
	}
	
	@RequestMapping(path = "/", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@RequestHeader String token) {
		Integer idUser = Tokens.getIdFromToken(token);
		userServiceRepository.deleteUser(idUser);
	}
	
	
	

}
