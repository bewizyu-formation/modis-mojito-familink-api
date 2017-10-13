package org.gestion.web.controller;

import org.gestion.entite.Login;
import org.gestion.repository.UserRepository;
import org.gestion.utils.Tokens;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class RestLoginController {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@ResponseBody
	@RequestMapping(path = "", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
	public ResponseEntity<String> authenticateUser(@RequestBody Login unLogin) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject unJson = new JSONObject();
		String dbPassword = userRepository.findPasswordByEmail(unLogin.getEmail());
		Integer idUser = userRepository.findIdUserByPassword(unLogin.getPassword());
		// headers.add("fbds", "headerValue");

		// ********** EMAIL EXISTS ? ********** //
		if (dbPassword == null) {
			unJson.put("login", "failed");
			unJson.put("description", "invalid Email");
			return new ResponseEntity<String>(unJson.toString(), headers, HttpStatus.BAD_REQUEST);
		}

		// ********** CHECK PASSWORD ********** //
		if (unLogin.getPassword().equals(dbPassword)) {
			unJson.put("token", Tokens.generateToken(idUser));
			return new ResponseEntity<String>(unJson.toString(), headers, HttpStatus.ACCEPTED);
		}
		// ********** CHECK PASSWORD ********** //
		else {
			unJson.put("description", "invalid Password");
			unJson.put("login", "failed");
			return new ResponseEntity<String>(unJson.toString(), headers, HttpStatus.BAD_REQUEST);
		}

	}

}