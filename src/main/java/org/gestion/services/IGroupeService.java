package org.gestion.services;

import java.util.List;

import org.gestion.entite.Groupe;

/**
 * Interface qui liste les méthodes de persistence pour la classe {@link Groupe} que doit posséder une classe
 * d'implémentation
 *
 * @author ThomasPortier
 */
public interface IGroupeService {
	
	/**
	 * Sauvegarde un nouveau groupe
	 *
	 * @param nouveauGroupe nouveau groupe
	 * @param token 
	 */
	Groupe create(Groupe nouveauGroupe, Integer token);

	/**
	 * Mise à jour d'un groupe
	 *
	 * @param groupe
	 */
	void update(Groupe groupe);

	/**
	 * Extrait tous les groupes existants
	 *
	 * @return
	 */
	List<Groupe> getGroupes();

	/**
	 * Récupération d'un groupe par son id
	 * @param id
	 * @return
	 */
	Groupe getGroupeById (final int id);

	/**
	 * Suppression d'un Groupe
	 * @param id
	 */
	void deleteGroupe(final int id);
	

}
