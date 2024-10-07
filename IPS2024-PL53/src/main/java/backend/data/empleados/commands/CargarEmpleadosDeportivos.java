package backend.data.empleados.commands;

import java.util.ArrayList;
import java.util.List;

import backend.data.Database;
import backend.data.empleados.EmpleadoDTO;

public class CargarEmpleadosDeportivos {

	private static final String QUERY_JUGADORES = "SELECT * FROM EMPLEADO_DEPORTIVO ED "
			+ "INNER JOIN JUGADOR J ON ED.ID_EMPLEADO_DEP = J.ID_JUGADOR";
	private static final String QUERY_ENTRENADORES = "SELECT * FROM EMPLEADO_DEPORTIVO ED "
			+ "INNER JOIN ENTRENADOR E ON ED.ID_EMPLEADO_DEP = E.ID_ENTRENADOR";

	private Database db = new Database();

	/**
	 * Hace dos selects (Una para jugadores y otra para entrenadores) y junta todos los empleados deportivos en la misma lista
	 * diferenciando jugadores de entrenadores por el atributo posicion de la clase EmpleadoDTO
	 * @return lista con todos los empleados deportivos de la BBDD
	 */
	public List<EmpleadoDTO> execute() {
		List<EmpleadoDTO> jugadores = db.executeQueryPojo(EmpleadoDTO.class, QUERY_JUGADORES);

		// Asigna el atributo posicion a los dto de los jugadores
		for (EmpleadoDTO jugador : jugadores)
			jugador.posicion = "jugador";

		List<EmpleadoDTO> entrenadores = db.executeQueryPojo(EmpleadoDTO.class, QUERY_ENTRENADORES);

		// Asigna el atributo posicion a los dto de los jugadores
		for (EmpleadoDTO entrenador : entrenadores)
			entrenador.posicion = "entrenador";

		List<EmpleadoDTO> empleados = new ArrayList<EmpleadoDTO>();
		empleados.addAll(jugadores);
		empleados.addAll(entrenadores);
		
		return empleados;
	}

}
