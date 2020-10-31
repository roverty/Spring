package org.rodrigo.cursos.spring.core.repository.jdbc.mapping;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.rodrigo.cursos.spring.core.domain.OrdenCompra;
import org.rodrigo.cursos.spring.core.domain.StatusOrden;
import org.rodrigo.cursos.spring.core.repository.OrdenCompraRepository;
import org.rodrigo.cursos.spring.core.repository.mapping.OrdenCompraMappingQuery;
import org.springframework.stereotype.Repository;

@Repository("ordenCompraRepository")
public class OrdenCompraJdbcMappingDao implements OrdenCompraRepository {
	
	@Resource
	private OrdenCompraMappingQuery ordenCompraMappingQueryById;
	
	@Resource
	private OrdenCompraMappingQuery ordenCompraMappingByRangoFechas;

	@Override
	public void guarda(OrdenCompra orden) {
		// TODO Auto-generated method stub

	}

	@Override
	public OrdenCompra obtenCompra(long id) {
		return ordenCompraMappingQueryById.findObject(id);
	}

	@Override
	public List<OrdenCompra> buscaOrdenes(Date fechaCompraInicio, Date fechaCompraFin, StatusOrden status) {
		return ordenCompraMappingByRangoFechas.execute(fechaCompraInicio,fechaCompraFin);
	}

	@Override
	public boolean existeOrden(OrdenCompra orden) {
		// TODO Auto-generated method stub
		return false;
	}

}
