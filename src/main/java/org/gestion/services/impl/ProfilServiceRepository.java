package org.gestion.services.impl;

import java.util.List;

import org.gestion.entite.Profil;
import org.gestion.repository.ProfilRepository;
import org.gestion.services.IProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value= "profilServiceRepository")
public class ProfilServiceRepository implements IProfilService {
	
	@Autowired
	private ProfilRepository profilRepository;

	@Override
	public Profil create(Profil nouveauProfil) {
		return profilRepository.save(nouveauProfil);
	}

	@Override
	public void update(Profil profil) {
		final Profil toUpdate = profilRepository.findOne(profil.getId());
		
		if (toUpdate != null ){
			toUpdate.setProfilName(profil.getProfilName());
			profilRepository.save(toUpdate);
		}
		
	}

	@Override
	public List<Profil> getProfils() {
		return profilRepository.findAll();
	}

	@Override
	public Profil getProfilById(int id) {
		return profilRepository.findOne(id);
	}

	@Override
	public void deleteProfil(int id) {
		profilRepository.delete(id);
		
	}

}
