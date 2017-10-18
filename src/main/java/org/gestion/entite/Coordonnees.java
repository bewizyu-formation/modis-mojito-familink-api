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
	
	@Column(name= "EMAIL", nullable= false, length=40, unique = true)
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
	public Coordonnees(String address, Integer zipCode, String city, String phone, String email) {
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.phone = phone;
		this.email = email;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the zipCode
	 */
	public Integer getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
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
