package backend.service.empleados;

import java.util.ArrayList;
import java.util.List;

import backend.service.ventas.Venta;
import shared.gestioninstalaciones.GerenteVentas;

public class Gerente implements GerenteVentas{
	private List<Venta> ventas = new ArrayList<Venta>();
	
	public List<Venta> getVentas() {
		return this.ventas;
	}

	@Override
	public void addVentaAGerenteVentas(Venta venta) {
		ventas.add(venta);
	}
}
