package org.gestion.services.impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.gestion.entite.User;
import org.gestion.repository.ContactRepository;
import org.gestion.repository.CoordonneesRepository;
import org.gestion.repository.UserRepository;
import org.gestion.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author FloRod
 */
@Service(value= "userServiceRepository")
public class UserServiceRepository implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CoordonneesRepository coordonneesRepository;
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public User create(User nouveauUser) {
		nouveauUser.setPassword(DigestUtils.md5Hex(nouveauUser.getPassword()));
		coordonneesRepository.save(nouveauUser.getContact().getCoordonnees());
		contactRepository.save(nouveauUser.getContact());
		return userRepository.save(nouveauUser);
		
	}

	@Override
	public void update(User user) {
		final User toUpdate = userRepository.findOne(user.getId());
		
		if(toUpdate != null){
			toUpdate.setContact(user.getContact());
			toUpdate.setPassword(DigestUtils.md5Hex(toUpdate.getPassword()));
			coordonneesRepository.save(toUpdate.getContact().getCoordonnees());
			contactRepository.save(toUpdate.getContact());
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
