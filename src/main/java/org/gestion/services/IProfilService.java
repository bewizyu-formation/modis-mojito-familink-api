package org.gestion.services;

import java.util.List;

import org.gestion.entite.Profil;

/**
 * Interface qui liste les méthodes de persistence pour la classe {@link Profil} que doit posséder une classe
 * d'implémentation
 *
 * @author FloRod
 */
public interface IProfilService {
	
	/**
	 * Sauvegarde un nouveau profil
	 *
	 * @param nouveauProfil nouveau profil
	 */
	Profil create(Profil nouveauProfil);

	/**
	 * Mise à jour d'un profil
	 *
	 * @param profil
	 */
	void update(Profil profil);

	/**
	 * Extrait tous les profils existants
	 *
	 * @return
	 */
	List<Profil> getProfils();

	/**
	 * Récupération d'un profil par son id
	 * @param id
	 * @return
	 */
	Profil getProfilById (final int id);

	/**
	 * Suppression d'un Profil
	 * @param id
	 */
	void deleteProfil(final int id);

}
