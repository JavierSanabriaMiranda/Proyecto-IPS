package backend.data;

import backend.data.empleados.EmpleadoCRUDImpl;
import backend.data.empleados.EmpleadosCRUDService;
import backend.data.productos.ProductoCRUDImpl;
import backend.data.productos.ProductoCRUDService;

public class CreadorDataService {

	public static EmpleadosCRUDService getEmpleadosService() {
		return new EmpleadoCRUDImpl();
	}

	public static ProductoCRUDService getproductoService() {
		return  new ProductoCRUDImpl();
	}
}
