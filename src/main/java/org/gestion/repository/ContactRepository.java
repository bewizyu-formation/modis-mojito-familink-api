package org.gestion.repository;

import java.util.List;

import org.gestion.entite.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	@Query(value = "SELECT * FROM contact AS c INNER JOIN groups_contacts AS gc on c.id = gc.CONTACT_ID WHERE GROUP_ID = ?1" , nativeQuery = true)
	List<Contact> findByGroupeIdTest(int idGroupe);
	
	@Query(value="SELECT * FROM contact INNER JOIN coordonnees ON contact.COORDONNEES_ID = coordonnees.id WHERE EMAIL = ?1", nativeQuery = true )
	Contact findByCoordonneesEmail(String email);
	
	@Query(value = "DROP * FROM contact WHERE GROUPE_ID = ?1", nativeQuery = true)
	void deleteByGroupId(int groupeId);

}

