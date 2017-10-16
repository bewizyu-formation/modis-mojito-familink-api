package org.gestion.web.controller;

import java.util.List;

import org.gestion.entite.Profil;
import org.gestion.services.IProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profils")
public class RestProfilController {
	
	@Autowired
	@Qualifier("profilServiceRepository")
	private IProfilService profileServiceRepository;
	
	@RequestMapping(path = "/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<Profil> getProfils(){
		return profileServiceRepository.getProfils();
	}

}
