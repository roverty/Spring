package org.rodrigo.cursos.spring.core.repository.mock;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.rodrigo.cursos.spring.core.domain.OrdenCompra;
import org.rodrigo.cursos.spring.core.domain.StatusOrden;
import org.rodrigo.cursos.spring.core.repository.OrdenCompraRepository;
import org.springframework.stereotype.Repository;

@Repository("ordenCompraRepository")
public class OrdenCompraRepositoryMock implements OrdenCompraRepository {
	
	private Set<OrdenCompra> ordenes = new HashSet<OrdenCompra>();
	
	

	@Override
	public void guarda(OrdenCompra orden) {
		// simular almacenaimiento en BD
		ordenes.add(orden);
	}

	@Override
	public OrdenCompra obtenCompra(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeOrden(OrdenCompra orden) {
		return ordenes.contains(orden);
	}

	@Override
	public List<OrdenCompra> buscaOrdenes(Date fechaCompraInicio, Date fechaCompraFin, StatusOrden status) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
