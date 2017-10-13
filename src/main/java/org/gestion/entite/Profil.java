package org.gestion.entite;

import javax.persistence.*;

@Entity
public class Profil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="PROFIL_NAME")
	private String profilName;
	
	@Column(name="COLOR")
	private String color;
	
	/**
	 * 
	 */
	public Profil() {
	}

	/**
	 * @param profilName
	 */
	public Profil(String profilName, String color) {
		this.profilName = profilName;
		this.color = color;
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

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	

}
