package org.gestion.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.gestion.entite.Contact;
import org.gestion.entite.Coordonnees;
import org.gestion.entite.Groupe;

import org.gestion.entite.Profil;

import org.gestion.entite.User;
import org.gestion.exceptions.FunctionalException;
import org.gestion.services.IInitializeService;
import org.gestion.utils.Tokens;
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

		// ******** création de la table des profils ********//

		Profil profil1 = new Profil("MEDECIN", "RED");
		profilServiceRepository.create(profil1);
		Profil profil2 = new Profil("INFIRMIERE", "BLUE");
		profilServiceRepository.create(profil2);
		Profil profil3 = new Profil("FAMILLE", "GREEN");
		profilServiceRepository.create(profil3);

		// ******** création de l'utilisateur1 et de son contact ********//
		
		String lienGravatar = "http://www.gravatar.com/avatar/3b3be63a4c2a439b013787725dfce802?d=mm";

		Coordonnees coordonnees1 = new Coordonnees("adresse 1", 69001, "ville 1", "0123456789", "mail_1@mail.com");
		Contact contact1 = new Contact("nom 1", "prenom 1", profil1, coordonnees1, lienGravatar);
		String passwordMD5 = DigestUtils.md5Hex("passeword 1");
		User user1 = new User(contact1, passwordMD5);
		try {
			userServiceRepository.create(user1);
		} catch (FunctionalException e2) {
			e2.printStackTrace();
		}

		// ******** création du groupe1 par l'utilisateur1 ********//
		// ajout par défaut du contact du propriétaire du groupe dans le groupe

		Set<Contact> listeContact1 = new HashSet<Contact>();
		listeContact1.add(contact1);
		Groupe groupe1 = new Groupe("Groupe 1", user1, listeContact1);
		try {
			groupeServiceRepository.create(groupe1, user1.getId());
		} catch (FunctionalException e1) {
			e1.printStackTrace();
		}

		// ******** création et ajout de nouveaux contacts par l'utilisateur1 dans le groupe1 ********//

		Coordonnees coordonnees2 = new Coordonnees("adresse 2", 69002, "ville 2", "0123456789", "mail_2@mail.com");
		Contact contact2 = new Contact("nom 2", "prenom 2", profil2, coordonnees2, lienGravatar);
		try {
			contactServiceRepository.create(contact2, groupe1.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Coordonnees coordonnees3 = new Coordonnees("adresse 3", 69003, "ville 3", "0123456789", "mail_3@mail.com");
		Contact contact3 = new Contact("nom 3", "prenom 3", profil3, coordonnees3, lienGravatar);
		try {
			contactServiceRepository.create(contact3, groupe1.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ******** création de l'utilisateur2 et de son contact ********//

		Coordonnees coordonnees4 = new Coordonnees("adresse 4", 69004, "ville 4", "0123456789", "mail_4@mail.com");
		Contact contact4 = new Contact("nom 4", "prenom 4", profil3, coordonnees4, lienGravatar);
		passwordMD5 = DigestUtils.md5Hex("passeword 2");
		User user2 = new User(contact4, passwordMD5);
		try {
			userServiceRepository.create(user2);
		} catch (FunctionalException e2) {
			e2.printStackTrace();
		}

		// ******** création du groupe2 par l'utilisateur2 ********//
		// ajout par défaut du contact du propriétaire du groupe dans le groupe

		Set<Contact> listeContact2 = new HashSet<Contact>();
		listeContact2.add(contact4);
		Groupe groupe2 = new Groupe("Groupe 2", user2, listeContact2);
		try {
			groupeServiceRepository.create(groupe2, user2.getId());
		} catch (FunctionalException e1) {
			e1.printStackTrace();
		}

		// ******** création et ajout de nouveaux contacts par l'utilisateur2 dans le groupe2 ********//

		Coordonnees coordonnees5 = new Coordonnees("adresse 5", 69005, "ville 5", "0123456789", "mail_5@mail.com");
		Contact contact5 = new Contact("nom 5", "prenom 5", profil2, coordonnees5, lienGravatar);
		try {
			contactServiceRepository.create(contact5, groupe2.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Coordonnees coordonnees6 = new Coordonnees("adresse 6", 69006, "ville 6", "0123456789", "mail_6@mail.com");
		Contact contact6 = new Contact("nom 6", "prenom 6", profil2, coordonnees6, lienGravatar);
		try {
			contactServiceRepository.create(contact6, groupe2.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ******** création de l'utilisateur3 et de son contact ********//

		Coordonnees coordonnees7 = new Coordonnees("adresse 7", 69007, "ville 7", "0123456789", "mail_7@mail.com");
		Contact contact7 = new Contact("nom 7", "prenom 7", profil2, coordonnees7, lienGravatar);
		passwordMD5 = DigestUtils.md5Hex("passeword 3");
		User user3 = new User(contact7, passwordMD5);
		try {
			userServiceRepository.create(user3);
		} catch (FunctionalException e) {
			e.printStackTrace();
		}

		 //******** création du groupe3 par l'utilisateur3 ********//
		 // ajout par défaut du contact du propriétaire du groupe dans le groupe
		
		 Set<Contact> listeContact3 = new HashSet<Contact>();
		 listeContact3.add(contact7);
		 Groupe groupe3 = new Groupe("Groupe 3", user3, listeContact3);
		 try {
			groupeServiceRepository.create(groupe3, user3.getId());
		} catch (FunctionalException e) {
			e.printStackTrace();
		}
		
		
		
		 //******** ajout de contacts existant par l'utilisateur3 dans le groupe3 ********//
		
		 listeContact3.add(contact1);
		 listeContact3.add(contact6);
		 groupe3.setContacts(listeContact3);
		 groupeServiceRepository.update(groupe3);

	}

}
