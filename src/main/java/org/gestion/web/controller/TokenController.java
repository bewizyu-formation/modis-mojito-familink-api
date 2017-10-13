package org.gestion.web.controller;

import org.gestion.utils.Tokens;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/**")
public class TokenController {
	
	
	@RequestMapping(path = "", method = RequestMethod.GET, consumes = "application/json;charset=UTF-8")
	public Boolean isRequestGranted(@RequestHeader String Authorization) {
		if(Tokens.isValid(Authorization)){
			return true;
		}
		return false;			
	}

	
	
}
