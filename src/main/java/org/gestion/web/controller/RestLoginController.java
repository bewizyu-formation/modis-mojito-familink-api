package org.gestion.web.controller;

import org.gestion.entite.User;
import org.gestion.repository.CoordonneesRepository;
import org.gestion.repository.UserRepository;
import org.gestion.utils.Tokens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class RestLoginController {
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	

	

}