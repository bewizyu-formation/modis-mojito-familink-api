package org.gestion.entite;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Groupe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@JsonIgnore //à priori inutile dans le json
	@OneToOne
	@JoinColumn(name="OWNERUSER_ID")
	private User owner;
	
	@JsonIgnore // evite la boucle lorsque le json est généré - données inutilse dans le json
	@ManyToMany(cascade= {CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@JoinTable(name = "GROUPS_CONTACTS", 
	joinColumns = @JoinColumn (name = "GROUP_ID", referencedColumnName = "ID"), 
	inverseJoinColumns = @JoinColumn(name = "CONTACT_ID", referencedColumnName = "ID"))
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

	 * @return the id
	 */
	public Integer getId() {
		return id;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Groupe other = (Groupe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
