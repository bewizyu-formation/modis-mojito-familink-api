package org.gestion.entite;

import javax.persistence.*;

@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name= "LASTNAME", nullable= false, length=30)
	private String lastName;
	
	@Column(name= "FIRSTNAME", nullable= false, length=30)
	private String firstName;
	
	@OneToOne//(cascade={CascadeType.PERSIST})
	@JoinColumn(name= "PROFIL_ID")
	private Profil profil;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name= "COORDONNEES_ID")
	private Coordonnees coordonnees;
	
	@Column(name= "GRAVATAR_URL", length=60)
	private String gravatar;
	
	@ManyToOne
	@JoinColumn(name="GROUPE_ID", nullable = true)
	private Groupe groupe;
	

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
	 * @return the nom
	 */
	public String getNom() {
		return lastName;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.lastName = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return firstName;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.firstName = prenom;
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
	 * @return the group
	 */
	public Groupe getGroup() {
		return groupe;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(Groupe group) {
		this.groupe = group;
	}
	
	
}
