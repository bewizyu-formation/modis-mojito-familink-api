package org.gestion.repository;

import org.gestion.entite.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "select password from user where CONTACT_ID = "
			+ "(select id from contact where COORDONNEES_ID = "
			+ "(select id from coordonnees where email = ?1))", nativeQuery = true)
	String findPasswordByEmail(String email);

	
	@Query(value = "select id FROM user where password = ?1", nativeQuery = true)
	Integer findIdUserByPassword(String password);


}
