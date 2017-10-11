package org.gestion.services.impl;

import org.gestion.entite.Contact;
import org.gestion.entite.Coordonnees;
import org.gestion.entite.Groupe;
import org.gestion.entite.User;
import org.gestion.services.IInitializeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitializeService implements IInitializeService {

	@Autowired
	private ContactServiceRepository contactServiceRepository;

	@Autowired
	private CoordonneesServiceRepository coordonneesServiceRepository;

	@Autowired
	private GroupeServiceRepository groupeServiceRepository;
	
	@Autowired
	private UserServiceRepository userServiceRepository;

	@Override
	public void initialize() {


		Coordonnees coordonnees1 = new Coordonnees("adresse 1", 69001, "ville 1", "0123456789", "mail_1@mail.com");
		coordonneesServiceRepository.create(coordonnees1);
	
		Contact unContact = new Contact("nom 4", "prenom 4", null, coordonnees1, "lien4");
		contactServiceRepository.create(unContact);
		
		User user1 = new User(unContact, "passeword 1");
		userServiceRepository.create(user1);
		
		Groupe groupe1 = new Groupe("Groupe 1", user1);
		groupeServiceRepository.create(groupe1);
		
		unContact.setGroup(groupe1);
		contactServiceRepository.update(unContact);


	}

}
