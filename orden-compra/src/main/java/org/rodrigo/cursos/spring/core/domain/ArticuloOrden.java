package org.rodrigo.cursos.spring.core.domain;

/**
 * TODO [Add class documentation]
 */
public class ArticuloOrden {
  private Articulo articulo;
  private int cantidad;

  /**
   * TODO [Add method documentation]
   * @return
   */
  public Articulo getArticulo() {
    return articulo;
  }

  /**
   * TODO [Add method documentation]
   * @param articulo
   */
  public void setArticulo(Articulo articulo) {
    this.articulo = articulo;
  }

  /**
   * TODO [Add method documentation]
   * @return
   */
  public int getCantidad() {
    return cantidad;
  }

  /**
   * TODO [Add method documentation]
   * @param cantidad
   */
  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  @Override
  public String toString() {
    return "ArticuloOrden [articulo=" + articulo + ", cantidad=" + cantidad + "]";
  }

}
