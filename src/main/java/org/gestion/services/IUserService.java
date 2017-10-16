package org.gestion.services;

import java.util.List;

import org.gestion.entite.User;
import org.gestion.exceptions.FunctionalException;

/**
 * Interface qui liste les méthodes de persistence pour la classe {@link User} que doit posséder une classe
 * d'implémentation
 *
 * @author FloRod
 */

public interface IUserService {
	
	/**
	 * Sauvegarde un nouvel utilisateur
	 *
	 * @param nouveauUser nouveau user
	 */
	User create(User nouveauUser) throws FunctionalException;

	/**
	 * Mise à jour d'un user
	 *
	 * @param user
	 */
	void update(User user);

	/**
	 * Extrait tous les users existants
	 *
	 * @return
	 */
	List<User> getUsers();

	/**
	 * Récupération d'un user par son id
	 * @param id
	 * @return
	 */
	User getUserById (final int id);

	/**
	 * Suppression d'un user
	 * @param id
	 */
	void deleteUser(final int id);
	

}
