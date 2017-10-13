package org.gestion.entite;

import javax.persistence.*;

@Entity
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="CONTACT_ID")
	private Contact contact;
	
	@Column(name="PASSWORD", nullable= false, length = 120)
	private String password;

	/**
	 * 
	 */
	public User() {
	}

	

	/**
	 * @param contact
	 * @param password
	 */
	public User(Contact contact, String password) {
		super();
		this.contact = contact;
		this.password = password;
	}



	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
	}

}
