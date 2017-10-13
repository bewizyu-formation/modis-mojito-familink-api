package org.gestion.services.impl;

import java.util.List;

import org.gestion.entite.Contact;
import org.gestion.services.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.gestion.repository.ContactRepository;

/**
 * @author FloRod
 */
@Service(value = "contactServiceRepository")
public class ContactServiceRepository implements IContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contact create(Contact nouveauContact) {
		return contactRepository.save(nouveauContact);
	}

	@Override
	public void update(Contact contact) {
		final Contact toUpdate = contactRepository.findOne(contact.getId());

		if (toUpdate != null) {
			toUpdate.setCoordonnees(contact.getCoordonnees());
			toUpdate.setNom(contact.getNom());
			toUpdate.setPrenom(contact.getPrenom());
			toUpdate.setProfil(contact.getProfil());
			toUpdate.setGravatar(contact.getGravatar());
			toUpdate.setGroup(contact.getGroup());
			contactRepository.save(toUpdate);
		}
	}

	@Override
	public List<Contact> getContacts(int groupeId) {
		return contactRepository.findByGroupId(groupeId);

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
