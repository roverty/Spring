package org.rodrigo.cursos.spring.core;

/**
 * TODO [Add class documentation]
 */
public class MensajeService {

  // Atributo que se inyectado por Spring
  private String mensaje;

  /**
   * TODO [Add method documentation]
   * @return
   */
  public String decoraMensaje() {
    return "¡" + mensaje + "!";
  }

  /**
   * TODO [Add method documentation]
   * @param mensaje
   */
  public void setMensaje(String mensaje) {
    this.mensaje = mensaje;
  }

}
