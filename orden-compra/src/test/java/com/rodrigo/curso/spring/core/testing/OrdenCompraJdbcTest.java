package com.rodrigo.curso.spring.core.testing;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.rodrigo.cursos.spring.core.domain.Articulo;
import org.rodrigo.cursos.spring.core.domain.ArticuloOrden;
import org.rodrigo.cursos.spring.core.domain.OrdenCompra;
import org.rodrigo.cursos.spring.core.domain.StatusOrden;
import org.rodrigo.cursos.spring.core.service.OrdenCompraService;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * TODO [Add class documentation]
 */
@SpringJUnitConfig(locations = { "/serviceAppContext.xml", "/jdbcDaoAppContext.xml",
  "/jdbcH2AppContext.xml" })
public class OrdenCompraJdbcTest {

  @Resource
  private OrdenCompraService ordenCompraService;

  private static final Logger logger = LogManager.getLogger();

  /**
   * TODO [Add method documentation]
   */
  @Test
  public void registraOrdenCompra() {
    OrdenCompra compra;
    Articulo articulo;
    ArticuloOrden articuloOrden;

    compra = new OrdenCompra();
    compra.setId(1L);
    compra.setFechaCompra(new Date());
    compra.setStatus(StatusOrden.REGISTRADA);
    compra.setFechaStatus(new Date());

    // Agregando un articulo a la orden
    articulo = new Articulo();
    articulo.setId(1);
    articulo.setNombre("Laptop");
    articulo.setPrecio(15400);

    articuloOrden = new ArticuloOrden();
    articuloOrden.setArticulo(articulo);
    articuloOrden.setCantidad(3);

    compra.setArticulos(List.of(articuloOrden));

    logger.debug("Registrando una nueva orden de compra: {}", compra);
    ordenCompraService.registraOrden(compra);

    logger.debug("Verificando la existencia de la orden en la BD");
    assertTrue(ordenCompraService.existeOrden(compra),
      "La orden de compra con id " + compra.getId() + " no se persistio");

  }
}
