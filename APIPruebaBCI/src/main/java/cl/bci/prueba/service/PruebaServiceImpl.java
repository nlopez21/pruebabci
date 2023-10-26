package cl.bci.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.bci.prueba.dao.BCIDAO;
import cl.bci.prueba.error.ErrorMessage;
import cl.bci.prueba.model.PruebaResponse;
import cl.bci.prueba.model.dto.UserDTO;
@Service
public class PruebaServiceImpl implements PruebaService{

	@Autowired
	BCIDAO dao;
	
	@Override
	public PruebaResponse saveUser(UserDTO user) throws Exception {
		
		return dao.saveUser(user);
	}

	@Override
	public List<PruebaResponse> getAll() {
	
		return dao.getAll();
	}

	@Override
	public PruebaResponse getOne(String email) {
	
		return dao.getOne(email);
	}

	@Override
	public PruebaResponse update(UserDTO user) throws Exception {
		
		return dao.update(user);
	}

	@Override
	public ErrorMessage delete(UserDTO user) throws Exception {
		
		return dao.delete(user);
	}
	
	

}
