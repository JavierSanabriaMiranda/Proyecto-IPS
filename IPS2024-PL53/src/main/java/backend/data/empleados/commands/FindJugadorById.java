package backend.data.empleados.commands;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import backend.data.Database;
import backend.data.equipos.JugadorDto;

public class FindJugadorById {

	private static final String QUERY = "SELECT "
	        + "ED.ID_EMPLEADO_DEP AS id, "
	        + "ED.DNI AS DNI, "
	        + "ED.NOMBRE AS nombre, "
	        + "ED.APELLIDO AS apellido, "
	        + "ED.FECHA_NACIMIENTO AS fechaNac, "
	        + "ED.TELEFONO AS telefono, "
	        + "ED.SALARIO_ANUAL AS salarioAnual, "
	        + "J.ID_EQUIPO AS idEquipo "
	        + "FROM EMPLEADO_DEPORTIVO ED "
	        + "INNER JOIN JUGADOR J ON ED.ID_EMPLEADO_DEP = J.ID_JUGADOR "
	        + "WHERE ED.ID_EMPLEADO_DEP = ?";
	
	private String id;
	private Database db = new Database();
	
	public FindJugadorById(String id) {
		if (id == null)
			throw new IllegalArgumentException("El id no puede ser null");
		this.id = id;
	}

	public Optional<JugadorDto> execute() {
		List<Map<String, Object>> mapsJugadores =  db.executeQueryMap(QUERY, id);
		if (mapsJugadores.isEmpty())
			return Optional.empty();
		return Optional.of(mapsToJugador(mapsJugadores).get(0));
	}
	
	private List<JugadorDto> mapsToJugador(List<Map<String, Object>> listaMap) {
		List<JugadorDto> lista = new ArrayList<>();
	    
	    // Recorre cada mapa y convierte los datos en un objeto EmpleadoDTO.
	    for (Map<String, Object> fila : listaMap) {
	    	JugadorDto dto = new JugadorDto(); // Renombrado a dto
	        dto.id_jugador = (String) fila.get("id");
	        dto.DNI = (String) fila.get("DNI");
	        dto.nombre = (String) fila.get("nombre");
	        dto.apellido = (String) fila.get("apellido");
	        dto.telefono = (String) fila.get("telefono");
	        dto.fechaNac = (Date) fila.get("fechaNac");
	        dto.idEquipo = (String) fila.get("idEquipo");
	        // Los valores "Decimal" de la base de datos se traen a java como BigDecimal por lo que
	        // es necesaria una conversión a double
	        BigDecimal salarioAnualBD = (BigDecimal) fila.get("salarioAnual");
	        if (salarioAnualBD != null) {
	            dto.salario = salarioAnualBD.doubleValue(); // Asigna el valor convertido a salarioAnual
	        } else {
	            dto.salario = 0.0; // Asigna 0.0 si salarioAnualBD es null
	        }
	        
	        lista.add(dto);
	    }
	    return lista; 		
	}

}
