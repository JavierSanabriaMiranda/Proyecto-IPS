package backend.data.ventas;

import java.util.List;

import backend.data.ventas.commands.AddClienteReserva;
import backend.data.ventas.commands.AddReserva;
import backend.data.ventas.commands.AddVentas;
import backend.data.ventas.commands.CargarReservas;
import backend.data.ventas.commands.FindByCodVentas;

public class VentasCRUDImpl implements VentasCRUDService {

	@Override
	public VentaDto findByCodVentas(String cod_ventas) {
		return new FindByCodVentas(cod_ventas).execute();
	}

	@Override
	public void addVentas(VentaDto venta) {
		new AddVentas(venta).execute();
	}
	
	@Override
	public void addReserva(ReservaDto dto) {
		new AddReserva(dto).execute();
	}

	@Override
	public void addCliente(ClienteReservaDto dto) {
		new AddClienteReserva(dto).execute();
	}

	@Override
	public List<ReservaDto> cargarReservas() {
		return new CargarReservas().execute();
	}

}
