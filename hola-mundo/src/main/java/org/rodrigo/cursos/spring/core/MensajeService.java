package org.rodrigo.cursos.spring.core;

public class MensajeService {
	
	// Atributo que se inyectado por Spring
	private String mensaje;
	
	public String decoraMensaje() {
		return "¡" + mensaje + "!";
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	
}
