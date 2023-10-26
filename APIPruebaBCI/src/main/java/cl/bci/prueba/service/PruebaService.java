package cl.bci.prueba.service;

import java.util.List;

import cl.bci.prueba.error.ErrorMessage;
import cl.bci.prueba.model.PruebaResponse;
import cl.bci.prueba.model.dto.UserDTO;

public interface PruebaService {

	PruebaResponse saveUser(UserDTO user) throws Exception;
	List<PruebaResponse> getAll();
	PruebaResponse getOne(String email);
	PruebaResponse update (UserDTO user) throws Exception;
	ErrorMessage delete (UserDTO user) throws Exception;
}
