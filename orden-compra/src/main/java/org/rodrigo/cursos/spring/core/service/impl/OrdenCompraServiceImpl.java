package org.rodrigo.cursos.spring.core.service.impl;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.rodrigo.cursos.spring.core.domain.OrdenCompra;
import org.rodrigo.cursos.spring.core.repository.OrdenCompraRepository;
import org.rodrigo.cursos.spring.core.service.OrdenCompraService;
import org.springframework.stereotype.Service;

/**
 * TODO [Add class documentation]
 */
@Service("ordenCompraService")
public class OrdenCompraServiceImpl implements OrdenCompraService {

  @Resource
  private OrdenCompraRepository ordenCompraRepository;

  private static final Logger logger = LogManager.getLogger(OrdenCompraServiceImpl.class);

  @Override
  public void registraOrden(OrdenCompra orden) {
    logger.debug("Processando la orden de compra {}", orden);
    if (orden.getArticulos() == null || orden.getArticulos().size() == 0) {
      throw new IllegalArgumentException(
        "Orden invalida, Debe contener al menos un articulo");
    }
    logger.debug("Orden válida, registrando ...");

    ordenCompraRepository.guarda(orden);

  }

  @Override
  public OrdenCompra obtenOrdenCompra(long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean existeOrden(OrdenCompra orden) {

    return ordenCompraRepository.existeOrden(orden);
  }

}
