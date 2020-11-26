package org.rodrigo.cursos.spring.core.domain;

/**
 * TODO [Add class documentation]
 */
public class Articulo {

  private long id;

  private String nombre;

  private double precio;

  /**
   * TODO [Add method documentation]
   * @return
   */
  public long getId() {
    return id;
  }

  /**
   * TODO [Add method documentation]
   * @param id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * TODO [Add method documentation]
   * @return
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * TODO [Add method documentation]
   * @param nombre
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * TODO [Add method documentation]
   * @return
   */
  public double getPrecio() {
    return precio;
  }

  /**
   * TODO [Add method documentation]
   * @param precio
   */
  public void setPrecio(double precio) {
    this.precio = precio;
  }

  @Override
  public String toString() {
    return "Articulo [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
  }

}
