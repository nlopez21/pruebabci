package cl.bci.prueba.repository.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
	
	@Id
	private String id;
	
	private String name;
	private String email;
	private String password;

	
	private Date created;
	private Date modified;
	private Date last_login;
	
	private String token;
	private boolean isactive;
	
}
