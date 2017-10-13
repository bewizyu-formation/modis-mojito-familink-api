package org.gestion.entite;

<<<<<<< HEAD
import java.util.Set;
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
>>>>>>> 76b3b8ad9c9a002dc3c028b1dfcc87f4c9f818fe

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
<<<<<<< HEAD


=======
//	@JsonIgnore
//	@OneToMany(mappedBy="groupe")
//	private Set<Contact> contacts = new HashSet<Contact>();
>>>>>>> 76b3b8ad9c9a002dc3c028b1dfcc87f4c9f818fe

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
<<<<<<< HEAD
=======

>>>>>>> 76b3b8ad9c9a002dc3c028b1dfcc87f4c9f818fe
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
<<<<<<< HEAD
=======
	 * @return the contacts
	 */

	/**
	 * @param contacts the contacts to set
	 */


	/**
>>>>>>> 76b3b8ad9c9a002dc3c028b1dfcc87f4c9f818fe
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

}
