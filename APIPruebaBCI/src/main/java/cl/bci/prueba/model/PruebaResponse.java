package cl.bci.prueba.model;

import java.sql.Date;
import java.util.List;

import cl.bci.prueba.model.dto.PhoneDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PruebaResponse {

	private String name;
	private String email;
	
	private String id;
	private Date created;
	private Date modified;
	private Date last_login;
	private String token;
	private boolean isactive;
	
	private List<PhoneDTO> phones;
}
