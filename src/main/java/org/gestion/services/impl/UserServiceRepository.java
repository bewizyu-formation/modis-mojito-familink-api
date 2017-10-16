package org.gestion.services.impl;

import java.util.List;

import org.gestion.entite.Contact;
import org.gestion.entite.User;
import org.gestion.exceptions.FunctionalException;
import org.gestion.repository.ContactRepository;
import org.gestion.repository.UserRepository;
import org.gestion.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author FloRod
 */
@Service(value = "userServiceRepository")
public class UserServiceRepository implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public User create(User nouveauUser) throws FunctionalException {
		
		//recherche si le contact existe en base de données via son email
		Contact contactSaved = contactRepository.findByCoordonneesEmail(nouveauUser.getContact().getCoordonnees().getEmail());
		if (contactSaved != null) {
			//recherche si un utilisateur est associé au contact trouvé en base de donnée
			User userSaved = userRepository.findByContactId(contactSaved.getId());
			System.out.println("************contact détecté*************");
			if (userSaved != null) {
				throw new FunctionalException("create User", "An user with this email already exist");
			} else {
				throw new FunctionalException("create User", "A contact relative to this user already exist but it's impossible to match with it");
//				contactSaved.setCoordonnees(nouveauUser.getContact().getCoordonnees());
//				contactSaved.setFirstName(nouveauUser.getContact().getFirstName());
//				contactSaved.setLastName(nouveauUser.getContact().getLastName());
//				contactSaved.setProfil(nouveauUser.getContact().getProfil());
//				contactSaved.setGravatar(nouveauUser.getContact().getGravatar());
//				nouveauUser.setContact(contactSaved);
			}
		}
		return userRepository.save(nouveauUser);

	}

	@Override
	public void update(User user) {
		final User toUpdate = userRepository.findOne(user.getId());
		if (toUpdate != null) {
			toUpdate.setContact(user.getContact());
			toUpdate.setPassword(user.getPassword());
			userRepository.save(toUpdate);
		}

	}

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public void deleteUser(int id) {
		userRepository.delete(id);
	}

}
