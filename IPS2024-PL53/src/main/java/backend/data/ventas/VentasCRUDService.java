package backend.data.ventas;

import java.util.Date;
import java.util.List;

public interface VentasCRUDService {

	VentaDto findByCodVentas(String cod_ventas);

	void addVentas(VentaDto venta);

	void addReserva(ReservaDto dto);

	void addCliente(ClienteReservaDto dto);

	List<ReservaDto> cargarReservas();

	List<VentaDto> findVentasFechas(Date inicio, Date fin);
}
