package org.rodrigo.cursos.spring.core.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * TODO [Add class documentation]
 */
public class OrdenCompra implements Serializable {

  private Long id;

  private Date fechaCompra;

  private StatusOrden status;

  private Date fechaStatus;

  private List<ArticuloOrden> articulos;

  /**
   * TODO [Add method documentation]
   * @return
   */
  public Long getId() {
    return id;
  }

  /**
   * TODO [Add method documentation]
   * @param id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * TODO [Add method documentation]
   * @return
   */
  public Date getFechaCompra() {
    return fechaCompra;
  }

  /**
   * TODO [Add method documentation]
   * @param fechaCompra
   */
  public void setFechaCompra(Date fechaCompra) {
    this.fechaCompra = fechaCompra;
  }

  /**
   * TODO [Add method documentation]
   * @return
   */
  public List<ArticuloOrden> getArticulos() {
    return articulos;
  }

  /**
   * TODO [Add method documentation]
   * @param articulos
   */
  public void setArticulos(List<ArticuloOrden> articulos) {
    this.articulos = articulos;
  }

  /**
   * TODO [Add method documentation]
   * @return
   */
  public StatusOrden getStatus() {
    return status;
  }

  /**
   * TODO [Add method documentation]
   * @param status
   */
  public void setStatus(StatusOrden status) {
    this.status = status;
  }

  /**
   * TODO [Add method documentation]
   * @return
   */
  public Date getFechaStatus() {
    return fechaStatus;
  }

  /**
   * TODO [Add method documentation]
   * @param fechaStatus
   */
  public void setFechaStatus(Date fechaStatus) {
    this.fechaStatus = fechaStatus;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OrdenCompra other = (OrdenCompra) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "OrdenCompra [id=" + id + ", fechaCompra=" + fechaCompra + ", status=" + status
      + ", fechaStatus=" + fechaStatus + ", articulos=" + articulos + "]";
  }

}
