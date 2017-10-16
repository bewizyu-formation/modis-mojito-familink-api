package org.gestion.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.gestion.entite.Contact;
import org.gestion.entite.Groupe;
import org.gestion.exceptions.FunctionalException;
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

	@Override
	public void create(Contact nouveauContact, Integer idGroup) throws FunctionalException {

		// recherche du groupe courant dans la base de données à partir de sonid
		// (id obtenu via l'URL)
		Groupe groupeSaved = groupeRepository.findOne(idGroup);
		Contact contactSaved = contactRepository.findByCoordonneesEmail(nouveauContact.getCoordonnees().getEmail());

		// création des listes nécessaires à la relation groupe - contact (table
		// de jointure)
		Set<Groupe> groupes = new HashSet<Groupe>();
		Set<Contact> contacts = groupeSaved.getContacts();

		// vérification que le contact nouveauContact existe déjà en base de
		// données (via son mail)
		// ET qu'il n'est pas déjà ajouté au groupe courant
		if (contactSaved != null) {
			groupes.addAll(contactSaved.getGroupes());
			if (groupes.contains(groupeSaved)) {
				throw new FunctionalException("create Contact22", "contact is already defined in group");
			} else {
				nouveauContact = contactSaved;
			}
		}

		// ajout du matching groupe-contact côté contact et crééation du contact
		groupes.add(groupeSaved);
		nouveauContact.setGroupes(groupes);
		contactRepository.save(nouveauContact);

		// matching groupe-contact côté contact, update de la liste de contact
		// du groupe trouvé
		contacts.add(nouveauContact);
		groupeSaved.setContacts(contacts);
		groupeRepository.save(groupeSaved);
	}

	@Override
	public void update(Contact contact) {
		final Contact toUpdate = contactRepository.findOne(contact.getId());

		if (toUpdate != null) {
			if (contact.getCoordonnees() != null) {
				toUpdate.setCoordonnees(contact.getCoordonnees());
			}
			if (contact.getLastName() != null) {
				toUpdate.setLastName(contact.getLastName());
			}
			if (contact.getFirstName() != null) {
				toUpdate.setFirstName(contact.getFirstName());
			}
			if (contact.getGravatar() != null) {
				toUpdate.setGravatar(contact.getGravatar());
			}
			toUpdate.setProfil(contact.getProfil());
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
