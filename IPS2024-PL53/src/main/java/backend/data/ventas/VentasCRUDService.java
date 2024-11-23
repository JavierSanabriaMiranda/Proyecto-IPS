package backend.data.ventas;

import java.util.Date;
import java.util.List;

import backend.data.entradas.EntradaDTO;

public interface VentasCRUDService {

	VentaDto findByCodVentas(String cod_ventas);

	void addVentas(VentaDto venta);

	void addReserva(ReservaDto dto);
	
	void addEntrada(EntradaDTO entrada);

	List<ReservaDto> cargarReservas();

	List<VentaDto> findVentasFechas(Date inicio, Date fin);

	List<VentaDto> findVentasPeriocidadAnual(int year);
}
