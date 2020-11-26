package org.rodrigo.cursos.spring.core.service;

import org.rodrigo.cursos.spring.core.domain.OrdenCompra;

/**
 * TODO [Add class documentation]
 */
public interface OrdenCompraService {

  /**
   * TODO [Add method documentation]
   * @param orden
   */
  void registraOrden(OrdenCompra orden);

  /**
   * TODO [Add method documentation]
   * @param id
   * @return
   */
  OrdenCompra obtenOrdenCompra(long id);

  /**
   * TODO [Add method documentation]
   * @param orden
   * @return
   */
  boolean existeOrden(OrdenCompra orden);
}
