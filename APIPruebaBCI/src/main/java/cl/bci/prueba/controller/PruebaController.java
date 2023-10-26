package cl.bci.prueba.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.bci.prueba.error.ErrorMessage;
import cl.bci.prueba.model.PruebaResponse;
import cl.bci.prueba.model.dto.UserDTO;
import cl.bci.prueba.service.PruebaService;


@RestController
@RequestMapping("/prueba/api")
@Validated
public class PruebaController {
	
	@Autowired
	PruebaService service;
	
	@PostMapping(path="/save" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PruebaResponse> create(@RequestBody @Valid UserDTO user) throws Exception{		
		return new ResponseEntity<>(service.saveUser(user), HttpStatus.CREATED);
	};
	
	@GetMapping(path="/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PruebaResponse>> getAll(){
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
			
	}
	
	@GetMapping(path="/one/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PruebaResponse> getOne(@PathVariable @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
            message = "Formato de email no valido") String email){
		return new ResponseEntity<>(service.getOne(email), HttpStatus.OK);
			
	}
	
	@PostMapping(path="/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PruebaResponse> update(@RequestBody @Valid UserDTO user) throws Exception{		
		return new ResponseEntity<>(service.update(user), HttpStatus.CREATED);
	};
	
	@DeleteMapping(path="/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ErrorMessage> delete(@RequestBody @Valid UserDTO user) throws Exception{		
		return new ResponseEntity<>(service.delete(user), HttpStatus.CREATED);
	};
	
	
}
