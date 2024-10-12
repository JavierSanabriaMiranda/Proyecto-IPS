package backend.data.empleados.commands;

import backend.data.Database;
import backend.data.empleados.EmpleadoDTO;
import shared.gestionempleados.PuestoEmpleado;

public class EliminarEmpleado {

	private static final String QUERY_DEP = "DELETE FROM EMPLEADO_DEPORTIVO WHERE ID_EMPLEADO_DEP = ?";
	private static final String QUERY_JUGADOR = "DELETE FROM JUGADOR WHERE ID_JUGADOR = ?";
	private static final String QUERY_ENTRENADOR = "DELETE FROM ENTRENADOR WHERE ID_ENTRENADOR = ?";
	private static final String QUERY_NO_DEP = "DELETE FROM EMPLEADO_NO_DEPORTIVO WHERE ID_EMPLEADO_NO_DEP = ?";
	
	private Database db = new Database();
	private EmpleadoDTO dto;
	
	public EliminarEmpleado(EmpleadoDTO dto) {
		this.dto = dto;
	}
	
	public void execute() {
		if (dto.posicion.equals(PuestoEmpleado.JUGADOR.toString())) {
			db.executeUpdate(QUERY_JUGADOR, dto.id);
			db.executeUpdate(QUERY_DEP, dto.id);
		} else if (dto.posicion.equals(PuestoEmpleado.ENTRENADOR.toString())) {
			db.executeUpdate(QUERY_ENTRENADOR, dto.id);
			db.executeUpdate(QUERY_DEP, dto.id);
		} else {
			db.executeUpdate(QUERY_NO_DEP, dto.id);
		}	
	}

}
