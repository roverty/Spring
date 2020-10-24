package org.rodrigo.cursos.spring.core.repository;

import java.util.Date;
import java.util.List;

import org.rodrigo.cursos.spring.core.domain.OrdenCompra;
import org.rodrigo.cursos.spring.core.domain.StatusOrden;

public interface OrdenCompraRepository {
	
	void guarda(OrdenCompra orden);
	
	OrdenCompra obtenCompra(long id);
	
	List<OrdenCompra> buscaOrdenes(Date fechaCompraInicio, Date fechaCompraFin, StatusOrden status);

	boolean existeOrden(OrdenCompra orden);
}
