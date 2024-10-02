package backend.service.ventas;

import java.sql.Date;

public abstract class VentaBase implements Venta {
	private double precio;
	private Date fecha;
	
	public double getPrecio() {
		return this.precio;
	}
	
	public Date getFecha() {
		return this.fecha;
	}
}
