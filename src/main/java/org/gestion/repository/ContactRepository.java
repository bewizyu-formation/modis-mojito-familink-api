package org.gestion.repository;

import java.util.List;

import org.gestion.entite.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	@Query(value = "SELECT * FROM contact WHERE GROUPE_ID = ?1", nativeQuery = true)
	List<Contact> findByGroupId(int groupeId);
	
	@Query(value = "DROP * FROM contact WHERE GROUPE_ID = ?1", nativeQuery = true)
	void deleteByGroupId(int groupeId);

}

