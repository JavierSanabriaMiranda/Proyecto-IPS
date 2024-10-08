package backend.service.ventas;


import java.util.Date;

public abstract class VentaBase implements Venta {
	
	@Override
	public abstract float getPrecio();
	
	@Override
	public abstract Date getFecha();
}
