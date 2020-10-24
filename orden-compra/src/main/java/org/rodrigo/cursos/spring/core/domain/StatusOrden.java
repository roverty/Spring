package org.rodrigo.cursos.spring.core.domain;

public enum StatusOrden {
	REGISTRADA(1,"Registrada","Registrada"), PAGADA(2,"Pagada","Pagada"), 
	EN_ENVIO(3,"En envio","En envio"), ENTREGADA(4,"Entregada","Entregada"), 
	CANCELADA(5,"Cancelada","Cancelada");
	
	private StatusOrden(int id,String clave,String descripcion) {
		this.id = id;
		this.clave = clave;
		this.descripcion = descripcion;
	}
	
	private int id;
	
	private String clave;
	
	private String descripcion;
	
	public static StatusOrden valueOf(int id) {
		for(StatusOrden status: StatusOrden.values()) {
			if (status.id == id) {
				return status;
			}
		}
		throw new IllegalArgumentException("Id paa StatusOrden no soportado "+id);
	}

	public int getId() {
		return id;
	}

	public String getClave() {
		return clave;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
}
