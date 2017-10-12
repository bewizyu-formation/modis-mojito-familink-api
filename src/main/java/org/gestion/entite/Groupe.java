package org.gestion.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Groupe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="OWNERUSER_ID")
	private User owner;
	
//	@JsonIgnore
//	@OneToMany(mappedBy="groupe")
//	private Set<Contact> contacts = new HashSet<Contact>();

	/**
	 * 
	 */
	public Groupe() {
	}

	/**
	 * @param name
	 * @param owner
	 * @param contacts
	 */
	public Groupe(String name, User owner) {
		this.name = name;
		this.owner = owner;

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the owner
	 */
	public User getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}

	/**
	 * @return the contacts
	 */

	/**
	 * @param contacts the contacts to set
	 */


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

}
