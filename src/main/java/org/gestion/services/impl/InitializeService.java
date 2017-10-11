package org.gestion.services.impl;

import java.util.HashSet;
import java.util.Set;

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

		Set<Contact> list1 = new HashSet<Contact>();
		Set<Contact> list2 = new HashSet<Contact>();
		
		Groupe groupe1 = new Groupe("Groupe 1", null, null);
		groupeServiceRepository.create(groupe1);
		Groupe groupe2 = new Groupe("Groupe 2", null, null);
		groupeServiceRepository.create(groupe2);

//		for (int i = 0; i < 6; i++) {
//			Coordonnees coordonnees = new Coordonnees("adresse " + i, 69000, "ville " + i, "0123456789",
//					"mail" + i + "@mail.com");
//			coordonneesServiceRepository.create(coordonnees);
//			
//			if (i % 2 != 0) {
//				Contact contact = new Contact("nom " + i, "prenom " + i, null, coordonnees, null);
//				contact.setGroup(groupe1);
//				contactServiceRepository.create(contact);
//				list1.add(contact);
//			} else {
//				Contact contact = new Contact("nom " + i, "prenom " + i, null, coordonnees, null);
//				contact.setGroup(groupe2);
//				contactServiceRepository.create(contact);
//				list2.add(contact);
//			}
//		}
		
		Coordonnees coordonnees1 = new Coordonnees("adresse 1", 69001, "ville 1", "0123456789", "mail_1@mail.com");
		coordonneesServiceRepository.create(coordonnees1);
		Coordonnees coordonnees2 = new Coordonnees("adresse 2", 69002, "ville 2", "0123456789", "mail_2@mail.com");
		coordonneesServiceRepository.create(coordonnees2);
		Coordonnees coordonnees3 = new Coordonnees("adresse 3", 69003, "ville 3", "0123456789", "mail_3@mail.com");
		coordonneesServiceRepository.create(coordonnees3);
		Coordonnees coordonnees4 = new Coordonnees("adresse 4", 69004, "ville 4", "0123456789", "mail_4@mail.com");
		coordonneesServiceRepository.create(coordonnees4);
		Coordonnees coordonnees5 = new Coordonnees("adresse 5", 69005, "ville 5", "0123456789", "mail_5@mail.com");
		coordonneesServiceRepository.create(coordonnees5);
		Coordonnees coordonnees6 = new Coordonnees("adresse 6", 69006, "ville 6", "0123456789", "mail_6@mail.com");
		coordonneesServiceRepository.create(coordonnees6);
		
		Contact contact1 = new Contact("nom 1", "prenom 1", null, coordonnees1, "lien1");
		contact1.setGroup(groupe1);
		list1.add(contact1);
		contactServiceRepository.create(contact1);
		Contact contact2 = new Contact("nom 2", "prenom 2", null, coordonnees2, "lien2");
		contact2.setGroup(groupe2);
		list2.add(contact2);
		contactServiceRepository.create(contact2);
		Contact contact3 = new Contact("nom 3", "prenom 3", null, coordonnees3, "lien3");
		contact3.setGroup(groupe1);
		list1.add(contact3);
		contactServiceRepository.create(contact3);
		Contact contact4 = new Contact("nom 4", "prenom 4", null, coordonnees4, "lien4");
		contact4.setGroup(groupe2);
		list2.add(contact4);
		contactServiceRepository.create(contact4);
		Contact contact5 = new Contact("nom 5", "prenom 5", null, coordonnees5, "lien5");
		contact5.setGroup(groupe1);
		list1.add(contact5);
		contactServiceRepository.create(contact5);
		Contact contact6 = new Contact("nom 6", "prenom 6", null, coordonnees6, "lien6");
		contact6.setGroup(groupe2);
		list2.add(contact6);
		contactServiceRepository.create(contact6);
		
		User user1 = new User(contact1, "passeword 1");
		userServiceRepository.create(user1);
		User user2 = new User(contact4, "passeword 2");
		userServiceRepository.create(user2);
		User user3 = new User(contact6, "passeword 3");
		userServiceRepository.create(user3);
		
		groupe1.setContacts(list1);
		groupe1.setOwner(user1);
		groupe2.setContacts(list2);
		groupe2.setOwner(user2);
		groupeServiceRepository.update(groupe1);
		groupeServiceRepository.update(groupe2);
		

	}

}
