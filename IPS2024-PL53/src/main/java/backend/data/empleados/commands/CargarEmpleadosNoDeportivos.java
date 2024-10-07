package backend.data.empleados.commands;

import java.util.List;

import backend.data.Database;
import backend.data.empleados.EmpleadoDTO;

public class CargarEmpleadosNoDeportivos {
	
	private static final String QUERY = "SELECT * FROM EMPLEADO_NO_DEPORTIVO";

	private Database db = new Database();
	
	public List<EmpleadoDTO> execute() {
		List<EmpleadoDTO> empleados = db.executeQueryPojo(EmpleadoDTO.class, QUERY);
		return empleados;
	}

}
