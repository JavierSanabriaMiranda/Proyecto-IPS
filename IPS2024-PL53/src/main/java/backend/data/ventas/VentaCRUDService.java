package backend.data.ventas;

import java.util.List;

public interface VentaCRUDService {

	public void addReserva(ReservaDto dto);
	public void addVenta(VentaDto dto);
	public void addCliente(ClienteReservaDto dto);
	public List<ReservaDto> cargarReservas();
}
