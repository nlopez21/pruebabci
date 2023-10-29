package cl.bci.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.bci.prueba.repository.entity.PhoneEntity;
@Repository
public interface PhoneRepository extends JpaRepository<PhoneEntity, String>{

@Query(value = "SELECT * FROM PHONE WHERE ID_USER LIKE :id", nativeQuery = true)
 List<PhoneEntity> findByAllIdphone(String id);



@Transactional
@Modifying
@Query(value = "UPDATE PHONE set "
		+ "NUMBER = :number,"
		+ "CITY_CODE = :cityCode,"
		+ "COUNTRY_CODE = :countryCode "
		+ "WHERE ID_USER LIKE :id", nativeQuery = true)
 void update (String number, String cityCode, String countryCode, String id);
}
