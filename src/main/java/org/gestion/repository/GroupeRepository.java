package org.gestion.repository;

import java.util.List;

import org.gestion.entite.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroupeRepository extends JpaRepository<Groupe, Integer> {
	
	//@Query("SELECT g FROM Groupe g JOIN g.contacts c ON c.id = User.id WHERE User.id = ?1")
	@Query(value="SELECT * FROM groupe INNER JOIN GROUPS_CONTACTS ON groupe.id = GROUPS_CONTACTS.GROUP_ID INNER JOIN user on GROUPS_CONTACTS.CONTACT_ID = user.CONTACT_ID where user.id = ?1", nativeQuery = true)
	List<Groupe> findByUserContactId(int idUser);
	
	Groupe findByOwnerId(int idUser);

}
