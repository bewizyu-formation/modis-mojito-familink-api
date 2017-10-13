package org.gestion.web.controller;

import org.gestion.utils.Tokens;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/*")
public class RestHandlerController {

	@RequestMapping(path="{root}", method = RequestMethod.GET)
	public ModelAndView tokenValidation (@RequestHeader String token, @PathVariable("root") String root){
		System.out.println("Vérification du token .....");
		if (Tokens.isValid(token)){
			return new ModelAndView("redirect:"+ root);
		}
		else {
			return new ModelAndView("redirect:/error");
		}
	}

	@RequestMapping("/error")
	public void error (){
		System.out.println("ERROR !!! TOKEN INVALID!!!");
	}
}

