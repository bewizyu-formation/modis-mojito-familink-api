package org.gestion.entite;

import javax.persistence.*;

@Entity
public class Profil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//MEDECIN, FAMILLE, INFIRMIERE
	
	@Column(name="PROFIL_NAME")
	private String profilName;
	
	/**
	 * 
	 */
	public Profil() {
	}

	/**
	 * @param profilName
	 */
	public Profil(String profilName) {
		this.profilName = profilName;
	}

	/**
	 * @return the profilName
	 */
	public String getProfilName() {
		return profilName;
	}

	/**
	 * @param profilName the profilName to set
	 */
	public void setProfilName(String profilName) {
		this.profilName = profilName;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	
	
	

}
