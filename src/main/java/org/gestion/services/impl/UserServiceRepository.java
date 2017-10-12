package org.gestion.services.impl;

import java.util.List;

import org.gestion.entite.User;
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
	}

	@Override
	public void update(User user) {
		final User toUpdate = userRepository.findOne(user.getId());
		
		if(toUpdate != null){
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
