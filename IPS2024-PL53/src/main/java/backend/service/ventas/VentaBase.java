package backend.service.ventas;

import java.util.Date;

public abstract class VentaBase implements Venta {
	private float precio;
	private Date fecha;

	public VentaBase() {
		
	}
	public VentaBase( float precio, java.util.Date fecha2) {
		this.precio = precio;
		this.fecha = fecha2;
	}

	public float getPrecio() {
		return this.precio;
	}
	
	public Date getFecha() {
		return this.fecha;
	}
}
