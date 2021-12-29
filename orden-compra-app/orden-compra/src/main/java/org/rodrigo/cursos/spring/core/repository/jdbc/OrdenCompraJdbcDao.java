package org.rodrigo.cursos.spring.core.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.rodrigo.cursos.spring.core.domain.OrdenCompra;
import org.rodrigo.cursos.spring.core.domain.StatusOrden;
import org.rodrigo.cursos.spring.core.repository.OrdenCompraRepository;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Repository;

/**
 * TODO [Add class documentation]
 */
@Repository("ordenCompraRepository")
public class OrdenCompraJdbcDao extends GenericJdbcDao implements OrdenCompraRepository {

  private static final String creaOrdenQuery = "insert into orden_compra("
    + "orden_compra_id, fecha_compra, status_orden_id, fecha_status) values (?,?,?,?)";

  private static final String ordenCompraQueryPrefix =
    "select orden_compra_id, fecha_compra, "
      + "status_orden_id, fecha_status from orden_compra";

  private static final String ordenCompraById = "select fecha_compra, status_orden_id, "
    + "fecha_status from orden_compra where orden_compra_id = ?";

  private static final String ordenCompraPorFechaInicio =
    ordenCompraQueryPrefix + " where fecha_compra = ?";

  private static final String ordenCompraPorRangFechas =
    ordenCompraQueryPrefix + " where fecha_compra between ? and ?";

  private static final String ordenCompraPorStatus = " and status_orden_id = ?";

  private static final String ordenNextId = "select next value for orden_compra_seq";

  private static final String existeOrdenCompraQuery =
    "select count(*) from orden_compra where orden_compra_id = ?";

  @Override
  public void guarda(OrdenCompra orden) {
    int rows;
    long id;

    id = getJdbcTemplate().queryForObject(ordenNextId, Long.class);
    orden.setId(id);
    rows = getJdbcTemplate().update(creaOrdenQuery, orden.getId(), orden.getFechaCompra(),
      orden.getStatus().getId(), orden.getFechaStatus());

    if (rows != 1) {
      throw new IncorrectResultSizeDataAccessException(creaOrdenQuery, 1, rows);
    }

  }

  @Override
  public OrdenCompra obtenCompra(long id) {
    return getJdbcTemplate().queryForObject(ordenCompraById,
      OrdenCompraJdbcDao::ordenCompraRowMapper, id);
  }

  @Override
  public boolean existeOrden(OrdenCompra orden) {
    Integer count;

    count = getJdbcTemplate().queryForObject(existeOrdenCompraQuery, Integer.class,
      orden.getId());

    return count > 0 ? true : false;
  }

  @Override
  public List<OrdenCompra> buscaOrdenes(Date fechaCompraInicio, Date fechaCompraFin,
    StatusOrden status) {
    String query;
    List<Object> params;

    if (fechaCompraInicio == null) {
      throw new IllegalArgumentException(
        "Para realizar búsquedas debe especificarse al menos la fecha de inicio");
    }

    params = new ArrayList<>();

    // Criterio por fechas
    if (fechaCompraFin != null) {
      query = ordenCompraPorRangFechas;
      params.add(fechaCompraInicio);
      params.add(fechaCompraFin);
    } else {
      query = ordenCompraPorFechaInicio;
      params.add(fechaCompraInicio);
    }

    // Criterio por status
    if (status != null) {
      query += ordenCompraPorStatus;
      params.add(status.getId());
    }

    Object[] array = new Object[params.size()];
    params.toArray(array);

    return getJdbcTemplate().query(query, OrdenCompraJdbcDao::ordenCompraRowMapper,
      array);
  }

  /**
   * @param rowNum
   */
  private static OrdenCompra ordenCompraRowMapper(ResultSet rs, int rowNum)
    throws SQLException {
    OrdenCompra orden;
    int numCol = 1;
    orden = new OrdenCompra();
    orden.setId(Long.valueOf(numCol++));
    orden.setFechaCompra(rs.getDate(numCol++));
    orden.setStatus(StatusOrden.valueOf(rs.getInt(numCol++)));
    orden.setFechaStatus(rs.getDate(numCol++));
    return orden;
  }

}
