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





	}

}
