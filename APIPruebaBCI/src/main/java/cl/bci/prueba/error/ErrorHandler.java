package cl.bci.prueba.error;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(value = ErrorEmail.class)
	public ResponseEntity<ErrorMessage> errorEmail( ErrorEmail ee){	
		return new ResponseEntity<>(new ErrorMessage(ee.getMensaje()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage>errorMethodArgumentNotValidException(MethodArgumentNotValidException ee)
	{	StringBuilder sb = new StringBuilder();
			List<FieldError> errors = ee.getBindingResult().getFieldErrors().stream().collect(Collectors.toList());
			for (Iterator iterator = errors.iterator(); iterator.hasNext();) {
				FieldError fieldError = (FieldError) iterator.next();
				sb.append(fieldError.getField());
				sb.append(": ");
				sb.append(fieldError.getDefaultMessage()).append(" | ");			
			}
	
		return new ResponseEntity<>(new ErrorMessage(sb.toString()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<ErrorMessage>constraintViolationException(ConstraintViolationException ee)
	{						
		return new ResponseEntity<>(new ErrorMessage(ee.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<ErrorMessage>nullPointerException(NullPointerException ee)
	{						
		return new ResponseEntity<>(new ErrorMessage("No se encontro usuario"),HttpStatus.NOT_FOUND);
	}
	
	
}
