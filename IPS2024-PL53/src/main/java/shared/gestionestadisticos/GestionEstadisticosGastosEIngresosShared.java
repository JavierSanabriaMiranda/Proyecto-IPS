package shared.gestionestadisticos;

import java.time.Month;
import java.util.ArrayList;
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

	public List<GastoDto> getGastosMensuales(Month mes, int year) {
		GastoDto gastosEnUnMes = serviceGastos.findGastosPeriocidadAnual().get(mes.getValue());
		boolean bisiesto = year % 4 == 0;
		
		
		List<GastoDto> gastosPorDiaEnMes = new ArrayList<>();
		for (int i = 1; i <= mes.length(bisiesto); i++) {
			GastoDto gasto = new GastoDto();
			gasto.dia = i;
			gasto.mes = mes.getValue();
			gasto.year = year;
			gasto.gasto = gastosEnUnMes.gasto / mes.length(bisiesto);
			gastosPorDiaEnMes.add(gasto);
		}
		return gastosPorDiaEnMes;
	}

	public List<VentaDto> getIngresosMensuales(Month mes, int year) {
		return serviceVentas.findVentasPeriocidadMensual(mes.getValue(), year);
	}
	
	
}
