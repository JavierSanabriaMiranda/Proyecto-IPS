package backend.data.ventas;

public interface VentasCRUDService {

	VentasDTO findByCodVentas(String cod_ventas);
	
	void addVentas(VentasDTO venta);
}
