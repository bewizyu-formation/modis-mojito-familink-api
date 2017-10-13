package org.gestion.web.controller;

import java.util.List;

import org.gestion.entite.Groupe;
import org.gestion.services.IGroupeService;

import org.gestion.utils.Tokens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestHeader;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groups")
public class RestGroupeController {
	
	@Autowired
	@Qualifier("groupeServiceRepository")
	private IGroupeService groupeServiceRepository;
	
	// ******* GET LIST GROUPES ********** //
	
	@RequestMapping(path = "/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<Groupe> getGroupeWithRepository() {
		return groupeServiceRepository.getGroupes();
	}
	
	// ******* GET GROUPE BY ID ********** //
	
	@RequestMapping(path = "/{idGroupe}", method = RequestMethod.GET)
	@ResponseBody
	public Groupe getGroupeByIdWithQueryParam(@PathVariable("idGroupe") String idGroupe) {
		return groupeServiceRepository.getGroupeById(Integer.parseInt(idGroupe));
	}
	
	// ********** CREATE GROUPE ********** //
	// ****** TODO 1 GROUPE PER USER MAX ******* //
	
	@RequestMapping(path = "/", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")

	public Groupe createGroupe(@RequestBody Groupe newGroupe, @RequestHeader String Authorization) {
		Integer idUser = Tokens.getIdFromToken(Authorization);
		System.out.println("##############################################################################################"+idUser);
		return groupeServiceRepository.create(newGroupe,idUser);

	}
	
	// ********** UPDATE GROUPE ********** //
	
	@RequestMapping(path = "/", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
	@ResponseBody
	public void updateGroupe(@RequestBody Groupe updateGroupe) {
		groupeServiceRepository.update(updateGroupe);
	}
	
	// ******* DELETE GROUPE BY ID ******** //
	
	@RequestMapping(path = "/{idGroupe}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteGroupe(@PathVariable("idGroupe") String idGroupe) {
		groupeServiceRepository.deleteGroupe(Integer.parseInt(idGroupe));
	}

}
