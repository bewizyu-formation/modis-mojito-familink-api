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
	 * Sauvegarde un nouveau contact dans le groupe courant
	 *
	 * @param nouveauContact nouveau contact
	 */
	void create(Contact nouveauContact, Integer id) throws Exception;

	/**
	 * Mise à jour d'un contact
	 *
	 * @param contact
	 */
	void update(Contact contact);

	/**
	 * Extrait tous les contacts associés à un groupe
	 *
	 * @return
	 */

	List<Contact> getContacts(int idGroupe);




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
	

	/**
	 * Suppression de tous les contacts d'un groupe
	 * @param id
	 */
	void deleteByGroupId(final int id);
	


}
