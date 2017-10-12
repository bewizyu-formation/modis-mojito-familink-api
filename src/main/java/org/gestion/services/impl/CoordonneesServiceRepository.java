package org.gestion.services.impl;

import java.util.List;

import org.gestion.entite.Coordonnees;
import org.gestion.repository.CoordonneesRepository;
import org.gestion.services.ICoordonneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author FloRod
 */
@Service(value= "coordonneesServiceRepository")
public class CoordonneesServiceRepository implements ICoordonneeService {
	
	@Autowired
	private CoordonneesRepository coordonneesRepository;

	@Override
	public Coordonnees create(Coordonnees nouvellesCoordonnees) {
		return coordonneesRepository.save(nouvellesCoordonnees);
	}

	@Override
	public void update(Coordonnees coordonnees) {
		final Coordonnees toUpdate = coordonneesRepository.findOne(coordonnees.getId());
		
		if (toUpdate != null){
			toUpdate.setAdresse(coordonnees.getAdresse());
			toUpdate.setCodePostal(coordonnees.getCodePostal());
			toUpdate.setEmail(coordonnees.getEmail());
			toUpdate.setPhone(coordonnees.getPhone());
			toUpdate.setVille(coordonnees.getVille());
			coordonneesRepository.save(toUpdate);
		}

	}

	@Override
	public List<Coordonnees> getCoordonnees() {
		return coordonneesRepository.findAll();
	}

	@Override
	public Coordonnees getCoordonneesById(int id) {
		return coordonneesRepository.findOne(id);
	}

	@Override
	public void deleteCoordonnees(int id) {
		coordonneesRepository.delete(id);

	}

}
