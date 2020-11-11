/**
 * OrdenCompraHibernateDao.java
 * Creation Date: Nov 7, 2020, 8:01:51 PM
 *
 * Copyright (C) 2019,2020 The {COMPANY_NAME} and/or its affiliates.
 * All rights reserved. {COMPANY_NAME}/CONFIDENTIAL.
 * Use of this software is subject to the license terms.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 */

package org.rodrigo.cursos.spring.core.repository.hibernate;

import java.util.Date;
import java.util.List;

import org.rodrigo.cursos.spring.core.domain.OrdenCompra;
import org.rodrigo.cursos.spring.core.domain.StatusOrden;
import org.rodrigo.cursos.spring.core.repository.OrdenCompraRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO [Add class documentation]
 */
@Repository("ordenCompraRepository")
public class OrdenCompraHibernateDao extends GenericHibernateDaoImpl
  implements OrdenCompraRepository {

  /*
   * See the original documentation of the method declaration
   * @see
   * org.rodrigo.cursos.spring.core.repository.OrdenCompraRepository#guarda(org.rodrigo.
   * cursos.spring.core.domain.OrdenCompra)
   */
  @Override
  public void guarda(OrdenCompra orden) {
    save(orden);
  }

  /*
   * See the original documentation of the method declaration
   * @see
   * org.rodrigo.cursos.spring.core.repository.OrdenCompraRepository#obtenCompra(long)
   */
  @Override
  public OrdenCompra obtenCompra(long id) {
    return get(OrdenCompra.class, id);
  }

  /*
   * See the original documentation of the method declaration
   * @see
   * org.rodrigo.cursos.spring.core.repository.OrdenCompraRepository#buscaOrdenes(java.
   * util.Date, java.util.Date, org.rodrigo.cursos.spring.core.domain.StatusOrden)
   */
  @Override
  public List<OrdenCompra> buscaOrdenes(Date fechaCompraInicio, Date fechaCompraFin,
    StatusOrden status) {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * See the original documentation of the method declaration
   * @see org.rodrigo.cursos.spring.core.repository.OrdenCompraRepository#existeOrden(org.
   * rodrigo.cursos.spring.core.domain.OrdenCompra)
   */
  @Override
  public boolean existeOrden(OrdenCompra orden) {
    // TODO Auto-generated method stub
    return false;
  }

}
