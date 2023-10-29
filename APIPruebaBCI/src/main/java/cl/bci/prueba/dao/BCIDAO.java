package cl.bci.prueba.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;


import cl.bci.prueba.error.ErrorEmail;
import cl.bci.prueba.error.ErrorMessage;
import cl.bci.prueba.model.PruebaResponse;
import cl.bci.prueba.model.dto.PhoneDTO;
import cl.bci.prueba.model.dto.UserDTO;
import cl.bci.prueba.repository.PhoneRepository;
import cl.bci.prueba.repository.UserRepository;
import cl.bci.prueba.repository.entity.PhoneEntity;
import cl.bci.prueba.repository.entity.UserEntity;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor
public class BCIDAO {

	private final UserRepository userRepository;
	private final PhoneRepository phoneRepository;

	
	public PruebaResponse saveUser(UserDTO user)throws  Exception{
		
		existUserEmail(user);
		
		String jwt = Jwts.builder()                    		        
			    .header()                                  
			        .keyId("BCI")
			        .and()
			    .signWith(Jwts.SIG.HS256.key().build())   
			    .compact();   
		

		UserEntity userEntity =  UserEntity.builder()
				.id(UUID.randomUUID().toString())
				.name(user.getName())
				.email(user.getEmail())
				.password(user.getPassword())
				.isactive(true)
				.token(jwt)
				.created(new Date(System.currentTimeMillis()))
				.modified(new Date(System.currentTimeMillis()))
				.last_login(new Date(System.currentTimeMillis()))
				.build();

		    userRepository.save(userEntity);
		    
			for(PhoneDTO phonedto : user.getPhones()) {
				PhoneEntity phoneEntity = 
						PhoneEntity.builder()
						.id(UUID.randomUUID().toString())
						.idUser(userEntity.getId())
						.number(phonedto.getNumber())
						.cityCode(phonedto.getCitycode())
						.countryCode(phonedto.getCountrycode())
						.build();
	
				phoneRepository.save(phoneEntity);
			}
			
		
		return PruebaResponse.builder()
				.name(userEntity.getName())
				.email(userEntity.getEmail())
				.id(userEntity.getId())
				.created(userEntity.getCreated())
				.modified(userEntity.getModified())
				.last_login(userEntity.getLast_login())
				.token(userEntity.getToken())
				.isactive(userEntity.isIsactive())
				.phones(user.getPhones())
				.build();
		
	}
	
	public void existUserEmail(UserDTO user) throws Exception, ErrorEmail {
		UserEntity userEntity = new UserEntity();
		userEntity = userRepository.findByEmail(user.getEmail());
		if(userEntity != null) {
			 throw  new ErrorEmail("El correo ya registrado");
		}

	}
	
	
	public List<PruebaResponse> getAll() {
		
		List<PruebaResponse> listPruebaResponse = new ArrayList<PruebaResponse>();
		for(UserEntity userEntity : userRepository.findAll()) {	
			listPruebaResponse.add(PruebaResponse.builder()
					.name(userEntity.getName())
					.email(userEntity.getEmail())
					.id(userEntity.getId())
					.created(userEntity.getCreated())
					.modified(userEntity.getModified())
					.last_login(userEntity.getLast_login())
					.token(userEntity.getToken())
					.isactive(userEntity.isIsactive())
					.phones(getPhones(userEntity.getId()))
					.build());
		}	
		
		return listPruebaResponse;
		
		
	};
	
	public PruebaResponse getOne(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);
		return PruebaResponse.builder()
				.name(userEntity.getName())
				.email(userEntity.getEmail())
				.id(userEntity.getId())
				.created(userEntity.getCreated())
				.modified(userEntity.getModified())
				.last_login(userEntity.getLast_login())
				.token(userEntity.getToken())
				.isactive(userEntity.isIsactive())
				.phones(getPhones(userEntity.getId()))
				.build();
		
	}
	

	
	
	private List<PhoneDTO> getPhones(String id) {
		List<PhoneDTO>phones = new ArrayList<PhoneDTO>();
		for(PhoneEntity phoneEntity : phoneRepository.findByAllIdphone(id)) {
			PhoneDTO phonedto =  PhoneDTO.builder()
					.number(phoneEntity.getNumber())
					.citycode(phoneEntity.getCityCode())
					.countrycode(phoneEntity.getCountryCode())
					.build();
			phones.add(phonedto);
		}
		return phones ;		
	}
	

	
	
	public ErrorMessage delete(UserDTO user) {
		UserEntity userEntity = new UserEntity();
		userEntity = userRepository.findByEmail(user.getEmail());
		if(userEntity != null) {
			userRepository.delete(userEntity);
			return new ErrorMessage("Usuario eliminado");
		}else{
			return new ErrorMessage("Usuario no encontrado");}
	
	}
	
	public PruebaResponse update(UserDTO user) {
		UserEntity userEntity = userRepository.findByEmail(user.getEmail());
		userRepository.update(user.getName(), user.getEmail(), new Date(System.currentTimeMillis()), userEntity.isIsactive(), userEntity.getId());
		List<PhoneEntity> phoneEntity = phoneRepository.findByAllIdphone(userEntity.getId());
		phoneRepository.deleteAll(phoneEntity);
		
		for(PhoneDTO phone : user.getPhones()) {
			PhoneEntity newPhoneEntity = 
					PhoneEntity.builder()
					.id(UUID.randomUUID().toString())
					.idUser(userEntity.getId())
					.number(phone.getNumber())
					.cityCode(phone.getCitycode())
					.countryCode(phone.getCountrycode())
					.build();

			phoneRepository.save(newPhoneEntity);

		}
		
		UserEntity userEntityUpadte = userRepository.findByEmail(user.getEmail());	
		return PruebaResponse.builder()
				.name(userEntityUpadte.getName())
				.email(userEntityUpadte.getEmail())
				.id(userEntityUpadte.getId())
				.created(userEntityUpadte.getCreated())
				.modified(userEntityUpadte.getModified())
				.last_login(userEntityUpadte.getLast_login())
				.token(userEntityUpadte.getToken())
				.isactive(userEntityUpadte.isIsactive())
				.phones(getPhones(userEntityUpadte.getId()))
				.build();
		
	}
	
}
