package cl.bci.prueba.error;

import java.io.Serializable;

import lombok.Builder;


@Builder
public class ErrorEmail extends Exception implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String mensaje;
	
	

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public ErrorEmail(String mensaje) {
		
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	
	
	
}
