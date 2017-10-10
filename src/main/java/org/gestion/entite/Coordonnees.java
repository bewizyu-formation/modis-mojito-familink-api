package org.gestion.entite;

import javax.persistence.*;

@Entity
public class Coordonnees {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name= "ADDRESS", length=60)
	private String address;
	
	@Column(name= "ZIP_CODE")
	private Integer zipCode;
	
	@Column(name= "CITY", length=60)
	private String city;
	
	@Column(name= "PHONE", nullable= false, length=20)
	private String phone;
	
	@Column(name= "EMAIL", nullable= false, length=40)
	private String email;

	/**
	 * 
	 */
	public Coordonnees() {
	}

	/**
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param phone
	 * @param email
	 */
	public Coordonnees(String adresse, Integer codePostal, String ville, String phone, String email) {
		this.address = adresse;
		this.zipCode = codePostal;
		this.city = ville;
		this.phone = phone;
		this.email = email;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return address;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		address = adresse;
	}

	/**
	 * @return the codePostal
	 */
	public Integer getCodePostal() {
		return zipCode;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(Integer codePostal) {
		this.zipCode = codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return city;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.city = ville;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

}
