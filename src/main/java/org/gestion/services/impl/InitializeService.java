package org.gestion.services.impl;

import org.gestion.entite.Contact;
import org.gestion.entite.Coordonnees;
import org.gestion.entite.Groupe;

import org.gestion.entite.Profil;

import org.gestion.entite.User;
import org.gestion.services.IInitializeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitializeService implements IInitializeService {

	@Autowired
	private ContactServiceRepository contactServiceRepository;

	@Autowired
	private GroupeServiceRepository groupeServiceRepository;
	
	@Autowired
	private UserServiceRepository userServiceRepository;

	@Autowired
	private ProfilServiceRepository profilServiceRepository;

	@Override
	public void initialize() {
		
			Profil profil1 = new Profil("MEDECIN","RED");
			profilServiceRepository.create(profil1);
			Profil profil2 = new Profil("INFIRMIERE","BLUE");
			profilServiceRepository.create(profil2);
			Profil profil3 = new Profil("FAMILLE", "GREEN");
			profilServiceRepository.create(profil3);
		
		
		
		
		//création  d'un utilisateur et de son contact
		Coordonnees coordonnees1 = new Coordonnees("adresse 1", 69001, "ville 1", "0123456789", "mail_1@mail.com");
		Contact contact1 = new Contact("nom 1", "prenom 1", profil1, coordonnees1, "lien1");
		User user1 = new User(contact1, "passeword 1");
		userServiceRepository.create(user1);
		
		//création du groupe par l'utilisateur1
		Groupe groupe1 = new Groupe("Groupe 1", user1);
		contact1.setGroup(groupe1);
		groupeServiceRepository.create(groupe1,user1.getId());
		contactServiceRepository.update(contact1); // ajout par défaut du contact du propriétaire du groupe dans le groupe
		
		//ajout d'un nouveau contact par l'utilisateur1 dans le groupe
		Coordonnees coordonnees2 = new Coordonnees("adresse 2", 69002, "ville 2", "0123456789", "mail_2@mail.com");
		Contact contact2 = new Contact("nom 2", "prenom 2", profil2, coordonnees2, "lien2");
		contact2.setGroup(groupe1);
		contactServiceRepository.create(contact2);
		
		//ajout d'un nouveau contact par l'utilisateur1 dans le groupe
		Coordonnees coordonnees3 = new Coordonnees("adresse 3", 69003, "ville 3", "0123456789", "mail_3@mail.com");
		Contact contact3 = new Contact("nom 3", "prenom 3", profil3, coordonnees3, "lien3");
		contact3.setGroup(groupe1);
		contactServiceRepository.create(contact3);
		
		//création d'un nouvel utilisateur et de son contact
		Coordonnees coordonnees4 = new Coordonnees("adresse 4", 69004, "ville 4", "0123456789", "mail_4@mail.com");
		Contact contact4 = new Contact("nom 4", "prenom 4", profil3, coordonnees4, "lien4");
		User user2 = new User(contact4, "passeword 2");
		userServiceRepository.create(user2);
		
		//création du groupe par l'utilisateur2
		Groupe groupe2 = new Groupe("Groupe 2", user2);
		contact4.setGroup(groupe2);
		groupeServiceRepository.create(groupe2,user2.getId());
		contactServiceRepository.update(contact4); // ajout par défaut du contact du propriétaire du groupe dans le groupe
		
		//ajout d'un nouveau contact par l'utilisateur2 dans le groupe
		Coordonnees coordonnees5 = new Coordonnees("adresse 5", 69005, "ville 5", "0123456789", "mail_5@mail.com");
		Contact contact5 = new Contact("nom 5", "prenom 5", profil2, coordonnees5, "lien5");
		contact5.setGroup(groupe2);
		contactServiceRepository.create(contact5);
		
		//ajout d'un nouveau contact par l'utilisateur2 dans le groupe
		Coordonnees coordonnees6 = new Coordonnees("adresse 6", 69006, "ville 6", "0123456789", "mail_6@mail.com");	
		Contact contact6 = new Contact("nom 6", "prenom 6", profil2, coordonnees6, "lien6");
		contact6.setGroup(groupe2);
		contactServiceRepository.create(contact6);
		
		//création d'un nouvel utilisateur et de son contact
		Coordonnees coordonnees7 = new Coordonnees("adresse 7", 69007, "ville 7", "0123456789", "mail_7@mail.com");
		Contact contact7 = new Contact("nom 7", "prenom 7", profil2, coordonnees7, "lien7");
		User user3 = new User(contact7, "passeword 3");
		userServiceRepository.create(user3);


	}

}
