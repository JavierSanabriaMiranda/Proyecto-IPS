package backend.data;

import backend.data.clientes.ClientesCRUDImpl;
import backend.data.clientes.ClientesCRUDService;
import backend.data.empleados.EmpleadoCRUDImpl;
import backend.data.empleados.EmpleadosCRUDService;
import backend.data.entradas.EntradasCRUDImpl;
import backend.data.entradas.EntradasCRUDService;
import backend.data.partidos.PartidosCRUDImpl;
import backend.data.partidos.PartidosCRUDService;
import backend.data.ventas.VentasCRUDImpl;
import backend.data.ventas.VentasCRUDService;

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
	
	public static ClientesCRUDService getClientesService() {
		return new ClientesCRUDImpl();
	}
	
	public static VentasCRUDService getVentasService() {
		return new VentasCRUDImpl();
	}
}
