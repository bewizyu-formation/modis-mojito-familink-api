package org.gestion.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.gestion.entite.Contact;
import org.gestion.entite.Groupe;
import org.gestion.entite.User;
import org.gestion.repository.ContactRepository;
import org.gestion.repository.GroupeRepository;
import org.gestion.repository.UserRepository;
import org.gestion.services.IGroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author thomasportier
 */
@Service(value= "groupeServiceRepository")
public class GroupeServiceRepository implements IGroupeService {
	
	@Autowired
	private GroupeRepository groupeRepository;

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Groupe create(Groupe nouveauGroupe, Integer idUser) {
		User user = userRepository.findOne(idUser);
		nouveauGroupe.setOwner(user);
		Set<Contact> contacts = new HashSet<Contact>();
		contacts.add(user.getContact());
		nouveauGroupe.setContacts(contacts);
		return groupeRepository.save(nouveauGroupe);
	}

	@Override
	public void update(Groupe groupe) {
		final Groupe toUpdate = groupeRepository.findOne(groupe.getId());
		
		if (toUpdate != null) {
			toUpdate.setName(groupe.getName());
			toUpdate.setContacts(groupe.getContacts());

			groupeRepository.save(toUpdate);
		}

	}

	@Override
	public List<Groupe> getGroupes(int idUser) {
		return groupeRepository.findByOwnerId(idUser);
	}

	@Override
	public Groupe getGroupeById(int id) {
		return groupeRepository.findOne(id);
	}

	@Override
	public void deleteGroupe(int id) {
		groupeRepository.delete(id);

	}

}
