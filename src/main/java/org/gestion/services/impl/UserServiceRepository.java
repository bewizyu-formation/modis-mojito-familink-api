package org.gestion.services.impl;

import java.util.List;

<<<<<<< HEAD
import org.gestion.entite.User;
=======
import org.apache.commons.codec.digest.DigestUtils;
import org.gestion.entite.User;
import org.gestion.repository.ContactRepository;
import org.gestion.repository.CoordonneesRepository;
>>>>>>> 76b3b8ad9c9a002dc3c028b1dfcc87f4c9f818fe
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

	@Override
	public User create(User nouveauUser) {
		return userRepository.save(nouveauUser);
<<<<<<< HEAD
=======

>>>>>>> 76b3b8ad9c9a002dc3c028b1dfcc87f4c9f818fe
	}

	@Override
	public void update(User user) {
		final User toUpdate = userRepository.findOne(user.getId());
<<<<<<< HEAD
		
		if(toUpdate != null){
			toUpdate.setContact(user.getContact());
			toUpdate.setPassword(user.getPassword());
=======
		if (toUpdate != null) {
			toUpdate.setContact(user.getContact());
			toUpdate.setPassword(toUpdate.getPassword());
>>>>>>> 76b3b8ad9c9a002dc3c028b1dfcc87f4c9f818fe
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
