package backend.data;

import backend.data.empleados.EmpleadoCRUDImpl;
import backend.data.empleados.EmpleadosCRUDService;
import backend.data.entradas.EntradasCRUDImpl;
import backend.data.entradas.EntradasCRUDService;
import backend.data.partidos.PartidosCRUDImpl;
import backend.data.partidos.PartidosCRUDService;

public class CreadorDataService {

	public static EmpleadosCRUDService getEmpleadosService() {
		return new EmpleadoCRUDImpl();
	}
	
	public static EntradasCRUDService getEntradaService() {
		return new EntradasCRUDImpl();
	}
	
	public static PartidosCRUDService getPartidosService() {
		return new PartidosCRUDImpl();
	}
}
