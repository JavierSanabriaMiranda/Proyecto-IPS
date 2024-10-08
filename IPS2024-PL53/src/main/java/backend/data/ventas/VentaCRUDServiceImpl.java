package backend.data.ventas;

import java.util.List;

import backend.data.ventas.commands.AddClienteReserva;
import backend.data.ventas.commands.AddReserva;
import backend.data.ventas.commands.AddVenta;
import backend.data.ventas.commands.CargarReservas;

public class VentaCRUDServiceImpl implements VentaCRUDService {

	@Override
	public void addReserva(ReservaDto dto) {
		new AddReserva(dto).execute();
	}

	@Override
	public void addVenta(VentaDto dto) {
		new AddVenta(dto).execute();
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
