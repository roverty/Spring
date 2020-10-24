package org.rodrigo.cursos.spring.core.service;

import org.rodrigo.cursos.spring.core.domain.OrdenCompra;

public interface OrdenCompraService {
	
	void registraOrden(OrdenCompra orden);
	
	OrdenCompra obtenOrdenCompra(long id);
	
	boolean existeOrden(OrdenCompra orden);
}
