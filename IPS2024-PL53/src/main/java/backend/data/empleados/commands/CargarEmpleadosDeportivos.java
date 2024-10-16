package backend.data.empleados.commands;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import backend.data.Database;
import backend.data.empleados.EmpleadoDeportivoDTO;

public class CargarEmpleadosDeportivos {

	private static final String QUERY_JUGADORES = "SELECT "
	        + "ED.ID_EMPLEADO_DEP AS id, "
	        + "ED.DNI AS DNI, "
	        + "ED.NOMBRE AS nombre, "
	        + "ED.APELLIDO AS apellido, "
	        + "ED.FECHA_NACIMIENTO AS fechaNac, "
	        + "ED.TELEFONO AS telefono, "
	        + "ED.SALARIO_ANUAL AS salarioAnual, "
	        + "J.ID_EQUIPO AS idEquipo "
	        + "FROM EMPLEADO_DEPORTIVO ED "
	        + "INNER JOIN JUGADOR J ON ED.ID_EMPLEADO_DEP = J.ID_JUGADOR";
	
	private static final String QUERY_ENTRENADORES = "SELECT "
	        + "ED.ID_EMPLEADO_DEP AS id, "
	        + "ED.DNI AS DNI, "
	        + "ED.NOMBRE AS nombre, "
	        + "ED.APELLIDO AS apellido, "
	        + "ED.TELEFONO AS telefono, "
	        + "ED.FECHA_NACIMIENTO AS fechaNac, "
	        + "ED.SALARIO_ANUAL AS salarioAnual, "
	        + "E.ID_EQUIPO AS idEquipo "
	        + "FROM EMPLEADO_DEPORTIVO ED "
	        + "INNER JOIN ENTRENADOR E ON ED.ID_EMPLEADO_DEP = E.ID_ENTRENADOR";

	private Database db = new Database();

	/**
	 * Hace dos selects (Una para jugadores y otra para entrenadores) y junta todos los empleados deportivos en la misma lista
	 * diferenciando jugadores de entrenadores por el atributo posicion de la clase EmpleadoDTO
	 * @return lista con todos los empleados deportivos de la BBDD
	 */
	public List<EmpleadoDeportivoDTO> execute() {
		 List<Map<String, Object>> mapsJugadores = db.executeQueryMap(QUERY_JUGADORES);
		 List<EmpleadoDeportivoDTO> jugadores = mapsToEmpleado(mapsJugadores);

		// Asigna el atributo posicion a los dto de los jugadores
		for (EmpleadoDeportivoDTO jugador : jugadores)
			jugador.posicion = "jugador";

		List<Map<String, Object>> mapsEntrenadores = db.executeQueryMap(QUERY_ENTRENADORES);
		List<EmpleadoDeportivoDTO> entrenadores = mapsToEmpleado(mapsEntrenadores);

		// Asigna el atributo posicion a los dto de los jugadores
		for (EmpleadoDeportivoDTO entrenador : entrenadores)
			entrenador.posicion = "entrenador";

		List<EmpleadoDeportivoDTO> empleados = new ArrayList<EmpleadoDeportivoDTO>();
		empleados.addAll(jugadores);
		empleados.addAll(entrenadores);
		
		return empleados;
	}
	
	private List<EmpleadoDeportivoDTO> mapsToEmpleado(List<Map<String, Object>> listaMap) {
		List<EmpleadoDeportivoDTO> lista = new ArrayList<>();
	    
	    // Recorre cada mapa y convierte los datos en un objeto EmpleadoDTO.
	    for (Map<String, Object> fila : listaMap) {
	    	EmpleadoDeportivoDTO dto = new EmpleadoDeportivoDTO(); // Renombrado a dto
	        dto.id = (String) fila.get("id");
	        dto.DNI = (String) fila.get("DNI");
	        dto.nombre = (String) fila.get("nombre");
	        dto.apellido = (String) fila.get("apellido");
	        dto.telefono = (String) fila.get("telefono");
	        dto.fechaNac = (Date) fila.get("fechaNac");
	        dto.id_equipo = (String) fila.get("idEquipo");
	        // Los valores "Decimal" de la base de datos se traen a java como BigDecimal por lo que
	        // es necesaria una conversión a double
	        BigDecimal salarioAnualBD = (BigDecimal) fila.get("salarioAnual");
	        if (salarioAnualBD != null) {
	            dto.salarioAnual = salarioAnualBD.doubleValue(); // Asigna el valor convertido a salarioAnual
	        } else {
	            dto.salarioAnual = 0.0; // Asigna 0.0 si salarioAnualBD es null
	        }
	        
	        lista.add(dto);
	    }
	    return lista; 		
	}

}
