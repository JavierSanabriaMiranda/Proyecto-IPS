package backend.service.ventas;

import java.util.Date;

public abstract class VentaBase implements Venta {
	private double precio;
	private Date fecha;
	
	public VentaBase(double precio, java.util.Date fecha2) {
		this.precio = precio;
		this.fecha = fecha2;
	}

	public double getPrecio() {
		return this.precio;
	}
	
	public Date getFecha() {
		return this.fecha;
	}
}
