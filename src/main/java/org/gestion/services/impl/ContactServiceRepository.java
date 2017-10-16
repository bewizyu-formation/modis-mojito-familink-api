package org.gestion.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.gestion.entite.Contact;
import org.gestion.entite.Groupe;
import org.gestion.services.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.gestion.repository.ContactRepository;
import org.gestion.repository.GroupeRepository;

/**
 * @author FloRod
 */
@Service(value = "contactServiceRepository")
public class ContactServiceRepository implements IContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private GroupeRepository groupeRepository;
	
	@Autowired
	private GroupeServiceRepository groupeServiceRepository;

	@Override
	public void create(Contact nouveauContact, Integer idGroup) {
		Groupe groupeSaved = groupeRepository.findOne(idGroup);
		
		Set<Groupe> groupes = new HashSet<Groupe>();
		Set<Contact> contacts = groupeSaved.getContacts();
	
		groupes.add(groupeSaved);
		nouveauContact.setGroupes(groupes);
		contactRepository.save(nouveauContact);
		
		contacts.add(nouveauContact);
		groupeSaved.setContacts(contacts);
		groupeServiceRepository.update(groupeSaved);
	}

	@Override
	public void update(Contact contact) {
		final Contact toUpdate = contactRepository.findOne(contact.getId());

		if (toUpdate != null) {
			toUpdate.setCoordonnees(contact.getCoordonnees());
			toUpdate.setLastName(contact.getLastName());
			toUpdate.setFirstName(contact.getFirstName());
			toUpdate.setProfil(contact.getProfil());
			toUpdate.setGravatar(contact.getGravatar());
			contactRepository.save(toUpdate);
		}
	}

	@Override
	public List<Contact> getContacts(int idGroupe) {
		return contactRepository.findByGroupeIdTest(idGroupe);

	}

	@Override
	public Contact getContactById(int id) {
		return contactRepository.findOne(id);
	}

	@Override
	public void deleteContact(int id) {
		contactRepository.delete(id);
	}

	@Override
	public void deleteByGroupId(int id) {
		contactRepository.deleteByGroupId(id);
	}

}
