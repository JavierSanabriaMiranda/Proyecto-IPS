package backend.data.empleados.commands;

import backend.data.Database;
import backend.data.empleados.EmpleadoDeportivoDTO;
import shared.gestionempleados.PuestoEmpleado;

public class UpdateEquipoDeEmpleadoDeportivo {

	private final String SQL_JUGADOR = "UPDATE JUGADOR SET ID_EQUIPO = ? WHERE ID_JUGADOR = ?;";
	private final String SQL_ENTRENADOR = "UPDATE ENTRENADOR SET ID_EQUIPO = ?, POSICION_ENTRENADOR=?  WHERE ID_ENTRENADOR = ?;";

	private EmpleadoDeportivoDTO dto;
	
	private Database db = new Database();
	
	public UpdateEquipoDeEmpleadoDeportivo(EmpleadoDeportivoDTO dto) {
		this.dto = dto;
	}
	
	public void execute() {
		if(dto.posicion.equals(PuestoEmpleado.JUGADOR.toString()))
			db.executeUpdate(SQL_JUGADOR, dto.id_equipo, dto.id);
		else
			db.executeUpdate(SQL_ENTRENADOR, dto.id_equipo, dto.numeroEntrenador, dto.id);
	}
}
