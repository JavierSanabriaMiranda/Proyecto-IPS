package backend.data;

import backend.data.empleados.EmpleadoCRUDImpl;
import backend.data.empleados.EmpleadosCRUDService;
import backend.data.horarios.HorarioCRUDImpl;
import backend.data.horarios.HorarioCRUDService;

public class CreadorDataService {

	public static EmpleadosCRUDService getEmpleadosService() {
		return new EmpleadoCRUDImpl();
	}
	
	public static HorarioCRUDService getHorarioService() {
		return new HorarioCRUDImpl();
	}
}
