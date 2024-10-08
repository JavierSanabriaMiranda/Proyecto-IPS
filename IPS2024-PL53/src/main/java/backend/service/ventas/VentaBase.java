package backend.service.ventas;

import java.util.Date;

public abstract class VentaBase implements Venta {
	private float precio;
	private Date fecha;
	private String idVenta;
	
	
	public VentaBase(String idVenta, float precio, java.util.Date fecha2) {
		this.idVenta = idVenta;
		this.precio = precio;
		this.fecha = fecha2;
	}

	public float getPrecio() {
		return this.precio;
	}
	
	public Date getFecha() {
		return this.fecha;
	}
	
	public String getIdVenta() {
		return idVenta;
	}
	
	
}
