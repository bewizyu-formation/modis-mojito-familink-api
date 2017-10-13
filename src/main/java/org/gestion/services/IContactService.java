package org.gestion.services;

import java.util.List;

import org.gestion.entite.Contact;

/**
 * Interface qui liste les méthodes de persistence pour la classe {@link Contact} que doit posséder une classe
 * d'implémentation
 *
 * @author FloRod
 */

public interface IContactService {
	
	/**
	 * Sauvegarde un nouveau contact
	 *
	 * @param nouveauContact nouveau contact
	 */
	Contact create(Contact nouveauContact);

	/**
	 * Mise à jour d'un contact
	 *
	 * @param contact
	 */
	void update(Contact contact);

	/**
	 * Extrait tous les contacts existants
	 *
	 * @return
	 */
<<<<<<< HEAD
	List<Contact> getContacts(int groupeId);
=======
	List<Contact> getContacts();
>>>>>>> 76b3b8ad9c9a002dc3c028b1dfcc87f4c9f818fe

	/**
	 * Récupération d'un contact par son id
	 * @param id
	 * @return
	 */
	Contact getContactById (final int id);

	/**
	 * Suppression d'un Contact
	 * @param id
	 */
	void deleteContact(final int id);
	
<<<<<<< HEAD
	/**
	 * Suppression de tous les contacts d'un groupe
	 * @param id
	 */
	void deleteByGroupId(final int id);
	
=======
>>>>>>> 76b3b8ad9c9a002dc3c028b1dfcc87f4c9f818fe

}
