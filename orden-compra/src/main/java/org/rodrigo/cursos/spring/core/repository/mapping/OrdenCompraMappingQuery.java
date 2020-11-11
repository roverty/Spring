package org.rodrigo.cursos.spring.core.repository.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.rodrigo.cursos.spring.core.domain.OrdenCompra;
import org.rodrigo.cursos.spring.core.domain.StatusOrden;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

/**
 * TODO [Add class documentation]
 */
public class OrdenCompraMappingQuery extends MappingSqlQuery<OrdenCompra> {

  private static final String ordenCompraQueryPrefix =
    "select orden_compra_id, fecha_compra, "
      + "status_orden_id, fecha_status from orden_compra" + " where ";

  private static final String ordenCompraById =
    ordenCompraQueryPrefix + " orden_compra_id = ?";

  private static final String ordenCompraPorRangFechas =
    ordenCompraQueryPrefix + " fecha_compra between ? and ?";

  /**
   * TODO [Add field documentation]
   */
  public static final int BY_ID = 1;

  /**
   * TODO [Add field documentation]
   */
  public static final int BY_DATES = 2;

  /**
   * TODO [Add constructor documentation]
   * @param ds
   * @param criterio
   */
  public OrdenCompraMappingQuery(DataSource ds, int criterio) {
    StringBuilder sb;

    sb = new StringBuilder(ordenCompraQueryPrefix);

    switch (criterio) {
      case BY_ID:
        sb.append(ordenCompraById);
        declareParameter(new SqlParameter(Types.NUMERIC));
        break;
      case BY_DATES:
        sb.append(ordenCompraPorRangFechas);
        declareParameter(new SqlParameter(Types.DATE));
        declareParameter(new SqlParameter(Types.DATE));
        break;
      default:
        throw new IllegalArgumentException("Criterio invàlido: " + criterio);
    }
    setSql(sb.toString());
    compile();

  }

  @Override
  protected OrdenCompra mapRow(ResultSet rs, int rowNum) throws SQLException {
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
