package org.rodrigo.cursos.spring.core.domain;

public class ArticuloOrden {
	private Articulo articulo;
	private int cantidad;
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "ArticuloOrden [articulo=" + articulo + ", cantidad=" + cantidad + "]";
	}
	
}
