package org.gestion.services.impl;

import java.util.List;

import org.gestion.entite.Groupe;
<<<<<<< HEAD
import org.gestion.entite.User;
import org.gestion.repository.ContactRepository;
import org.gestion.repository.GroupeRepository;
import org.gestion.repository.UserRepository;
import org.gestion.services.IGroupeService;
import org.gestion.utils.Tokens;
=======
import org.gestion.repository.GroupeRepository;
import org.gestion.services.IGroupeService;
>>>>>>> 76b3b8ad9c9a002dc3c028b1dfcc87f4c9f818fe
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author thomasportier
 */
@Service(value= "groupeServiceRepository")
public class GroupeServiceRepository implements IGroupeService {
	
	@Autowired
	private GroupeRepository groupeRepository;
<<<<<<< HEAD
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Groupe create(Groupe nouveauGroupe, Integer id) {
		nouveauGroupe.setOwner(userRepository.findOne(id));
=======

	@Override
	public Groupe create(Groupe nouveauGroupe) {
>>>>>>> 76b3b8ad9c9a002dc3c028b1dfcc87f4c9f818fe
		return groupeRepository.save(nouveauGroupe);
	}

	@Override
	public void update(Groupe groupe) {
		final Groupe toUpdate = groupeRepository.findOne(groupe.getId());
		
		if (toUpdate != null) {
			toUpdate.setName(groupe.getName());
<<<<<<< HEAD
=======
			
>>>>>>> 76b3b8ad9c9a002dc3c028b1dfcc87f4c9f818fe
			groupeRepository.save(toUpdate);
		}

	}

	@Override
	public List<Groupe> getGroupes() {
		return groupeRepository.findAll();
	}

	@Override
	public Groupe getGroupeById(int id) {
		return groupeRepository.findOne(id);
	}

	@Override
	public void deleteGroupe(int id) {
<<<<<<< HEAD
		contactRepository.deleteByGroupId(id);
=======
>>>>>>> 76b3b8ad9c9a002dc3c028b1dfcc87f4c9f818fe
		groupeRepository.delete(id);

	}

}
