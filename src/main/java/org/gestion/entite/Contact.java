package org.gestion.entite;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name= "LASTNAME", nullable= false, length=30)
	private String lastName;
	
	
	@Column(name= "FIRSTNAME", nullable= false, length=30)
	private String firstName;
	
	@OneToOne
	@JoinColumn(name= "PROFIL_ID")
	private Profil profil;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name= "COORDONNEES_ID")
	private Coordonnees coordonnees;
	
	@Column(name= "GRAVATAR_URL", length=100)
	private String gravatar;
	
	@JsonIgnore
	@ManyToMany(mappedBy="contacts", fetch = FetchType.EAGER)
	private Set<Groupe> groupes = new HashSet<Groupe>();
	

	/**
	 * 
	 */
	public Contact() {
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param profil
	 * @param coordonnees
	 * @param gravatar
	 */
	public Contact(String nom, String prenom, Profil profil, Coordonnees coordonnees, String gravatar) {
		this.lastName = nom;
		this.firstName = prenom;
		this.profil = profil;
		this.coordonnees = coordonnees;
		this.gravatar = gravatar;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the profil
	 */
	public Profil getProfil() {
		return profil;
	}

	/**
	 * @param profil the profil to set
	 */
	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	/**
	 * @return the coordonnees
	 */
	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	/**
	 * @param coordonnees the coordonnees to set
	 */
	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	/**
	 * @return the gravatar
	 */
	public String getGravatar() {
		return gravatar;
	}

	/**
	 * @param gravatar the gravatar to set
	 */
	public void setGravatar(String gravatar) {
		this.gravatar = gravatar;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the groupes
	 */
	public Set<Groupe> getGroupes() {
		return groupes;
	}

	/**
	 * @param groupes the groupes to set
	 */
	public void setGroupes(Set<Groupe> groupes) {
		this.groupes = groupes;
	}
	
	
}
