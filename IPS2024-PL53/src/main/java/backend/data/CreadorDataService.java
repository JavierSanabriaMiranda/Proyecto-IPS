package backend.data;

import backend.data.ventas.VentaCRUDService;
import backend.data.ventas.VentaCRUDServiceImpl;

public class CreadorDataService {

	public static VentaCRUDService getEmpleadosService() {
		return new VentaCRUDServiceImpl();
	}

}
