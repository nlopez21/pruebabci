package cl.bci.prueba.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.bci.prueba.repository.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, UserEntity>{
	
	UserEntity findByEmail(String email);
	@Transactional
	@Modifying
	@Query(value = "UPDATE USER set "
			+ "NAME = :name,"
			+ "EMAIL = :email,"
			+ "MODIFIED = :modified, "
			+ "ISACTIVE = :isactive "
			+ "WHERE ID LIKE :id", nativeQuery = true)
	void update(String name, String email, Date modified, Boolean isactive, String id);
}
