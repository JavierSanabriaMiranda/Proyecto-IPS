package shared.gestionestadisticos;

import java.util.List;

import backend.data.CreadorDataService;
import backend.data.ventas.VentaDto;
import backend.data.ventas.VentasCRUDService;

public class GestionEstadisticosGastosEIngresosShared {

	VentasCRUDService serviceVentas = CreadorDataService.getVentasService();

	public List<VentaDto> getVentasAnual(int year) {
        return serviceVentas.findVentasPeriocidadAnual(year);
	}
	
	
}
