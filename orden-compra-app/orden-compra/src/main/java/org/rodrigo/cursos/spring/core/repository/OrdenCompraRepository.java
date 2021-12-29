package org.rodrigo.cursos.spring.core.repository;

import java.util.Date;
import java.util.List;

import org.rodrigo.cursos.spring.core.domain.OrdenCompra;
import org.rodrigo.cursos.spring.core.domain.StatusOrden;

/**
 * TODO [Add class documentation]
 */
public interface OrdenCompraRepository {

  /**
   * TODO [Add method documentation]
   * @param orden
   */
  void guarda(OrdenCompra orden);

  /**
   * TODO [Add method documentation]
   * @param id
   * @return
   */
  OrdenCompra obtenCompra(long id);

  /**
   * TODO [Add method documentation]
   * @param fechaCompraInicio
   * @param fechaCompraFin
   * @param status
   * @return
   */
  List<OrdenCompra> buscaOrdenes(Date fechaCompraInicio, Date fechaCompraFin,
    StatusOrden status);

  /**
   * TODO [Add method documentation]
   * @param orden
   * @return
   */
  boolean existeOrden(OrdenCompra orden);
}
