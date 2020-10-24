package com.rodrigo.curso.spring.core.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.rodrigo.cursos.spring.core.MensajeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO [Add class documentation]
 */
public class HolaMundoJunit5 {

  private static MensajeService mensajeService;

  private static ApplicationContext appContext;

  /**
   * Crear un spring container e inicializar el servicio <code>mensajeService</code>
   */
  @BeforeAll
  public static void beforeAll() {
    appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    mensajeService = (MensajeService) appContext.getBean("mensajeService");
  }

  /**
   * Cierra el application context
   */
  @AfterAll
  public static void afterAll() {
    ((ClassPathXmlApplicationContext) appContext).close();
  }

  /**
   * Prueba unitaria que verifica el funcionamiento del servicio
   * {@link MensajeService}
   */
  @Test
  public void holaMundo() {

    String mensajeDecorado;
    mensajeDecorado = mensajeService.decoraMensaje();

    assertEquals("¡Hola mundo!", mensajeDecorado, "Los mensajes no coinciden.");
  }

}
