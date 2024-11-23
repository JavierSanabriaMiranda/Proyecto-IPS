package shared.gestionestadisticos;

import java.util.List;

import backend.data.CreadorDataService;
import backend.data.gastos.GastoDto;
import backend.data.gastos.GastosCRUDService;
import backend.data.ventas.VentaDto;
import backend.data.ventas.VentasCRUDService;

public class GestionEstadisticosGastosEIngresosShared {

	VentasCRUDService serviceVentas = CreadorDataService.getVentasService();
	GastosCRUDService serviceGastos = CreadorDataService.getGastosService();

	/**
	 * Devuelve los ingresos totales obtenidos de las ventas agrupados por mes de un año concreto
	 */
	public List<VentaDto> getVentasAnuales(int year) {
        return serviceVentas.findVentasPeriocidadAnual(year);
	}

	/**
	 * Devuelve los gastos totales que se realizan cada mes provenientes de los salarios
	 * de los empleados
	 */
	public List<GastoDto> getGastosAnuales() {
		return serviceGastos.findGastosPeriocidadAnual();
	}
	
	
}
