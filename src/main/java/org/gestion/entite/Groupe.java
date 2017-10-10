package org.gestion.entite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Groupe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@OneToOne
	@JoinColumn(name="OWNERUSER_ID")
	private User owner;
	
	@OneToMany(mappedBy="groupe")
	private Set<Contact> contacts = new HashSet<Contact>();

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
	public Groupe(String name, User owner, Set<Contact> contacts) {
		this.name = name;
		this.owner = owner;
		this.contacts = contacts;
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
	public Set<Contact> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

}
