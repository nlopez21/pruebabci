package cl.bci.prueba.repository.entity;






import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="phone")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhoneEntity {
	
	
	@Id
	private String id;
	private String idUser;
	private String number;
	private String cityCode;
	private String countryCode;
	

}
