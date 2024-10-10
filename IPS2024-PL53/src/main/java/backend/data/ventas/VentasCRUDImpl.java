package backend.data.ventas;

import backend.data.ventas.commands.AddVentas;
import backend.data.ventas.commands.FindByCodVentas;

public class VentasCRUDImpl implements VentasCRUDService {

	@Override
	public VentasDTO findByCodVentas(String cod_ventas) {
		return new FindByCodVentas(cod_ventas).execute();
	}

	@Override
	public void addVentas(VentasDTO venta) {
		new AddVentas(venta).execute();
	}

}
