package org.gestion.services;

import java.util.List;

import org.gestion.entite.Coordonnees;

/**
 * Interface qui liste les méthodes de persistence pour la classe {@link Coordonnees} que doit posséder une classe
 * d'implémentation
 *
 * @author FloRod
 */
public interface ICoordonneeService {
	
	/**
	 * Sauvegarde des nouvelles coordonnées
	 *
	 * @param nouvellesCoordonnees nouvelles coordonnées
	 */
	Coordonnees create(Coordonnees nouvellesCoordonnees);

	/**
	 * Mise à jour des coordonnées
	 *
	 * @param coordonnees
	 */
	void update(Coordonnees coordonnees);

	/**
	 * Extrait toutes les coordonnées existantes
	 *
	 * @return
	 */
	List<Coordonnees> getCoordonnees();

	/**
	 * Récupération de coordonnées par son id
	 * @param id
	 * @return
	 */
	Coordonnees getCoordonneesById (final int id);

	/**
	 * Suppression de coordonnées
	 * @param id
	 */
	void deleteCoordonnees(final int id);
	

}
