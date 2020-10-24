package org.rodrigo.cursos.spring.core.domain;

import java.util.Date;
import java.util.List;

public class OrdenCompra {
	private long id;
	
	private Date fechaCompra;
	
	private StatusOrden status;
	
	private Date fechaStatus;
	
	private List<ArticuloOrden> articulos;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public List<ArticuloOrden> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<ArticuloOrden> articulos) {
		this.articulos = articulos;
	}

	public StatusOrden getStatus() {
		return status;
	}

	public void setStatus(StatusOrden status) {
		this.status = status;
	}

	public Date getFechaStatus() {
		return fechaStatus;
	}

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
		return "OrdenCompra [id=" + id + ", fechaCompra=" + fechaCompra + ", status=" + status + ", fechaStatus="
				+ fechaStatus + ", articulos=" + articulos + "]";
	}

	
	
}
