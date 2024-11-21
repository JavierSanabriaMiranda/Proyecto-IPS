package backend.data.empleados.commands;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import backend.data.Database;
import backend.data.equipos.EntrenadorDto;

public class FindEntrenadorById {

	private static final String QUERY = "SELECT "
	        + "ED.ID_EMPLEADO_DEP AS id, "
	        + "ED.DNI AS DNI, "
	        + "ED.NOMBRE AS nombre, "
	        + "ED.APELLIDO AS apellido, "
	        + "ED.TELEFONO AS telefono, "
	        + "ED.FECHA_NACIMIENTO AS fechaNac, "
	        + "ED.SALARIO_ANUAL AS salarioAnual, "
	        + "E.ID_EQUIPO AS idEquipo "
	        + "FROM EMPLEADO_DEPORTIVO ED "
	        + "INNER JOIN ENTRENADOR E ON ED.ID_EMPLEADO_DEP = E.ID_ENTRENADOR "
	        + "WHERE ED.ID_EMPLEADO_DEP = ?";
	
	private String id;
	private Database db = new Database();
	
	public FindEntrenadorById(String id) {
		if (id == null)
			throw new IllegalArgumentException("El id no puede ser null");
		this.id = id;
	}

	public Optional<EntrenadorDto> execute() {
		List<Map<String, Object>> mapsEntrenadores =  db.executeQueryMap(QUERY, id);
		if (mapsEntrenadores.isEmpty())
			return Optional.empty();
		return Optional.of(mapsToJugador(mapsEntrenadores).get(0));
	}
	
	private List<EntrenadorDto> mapsToJugador(List<Map<String, Object>> listaMap) {
		List<EntrenadorDto> lista = new ArrayList<>();
	    
	    // Recorre cada mapa y convierte los datos en un objeto EmpleadoDTO.
	    for (Map<String, Object> fila : listaMap) {
	    	EntrenadorDto dto = new EntrenadorDto(); // Renombrado a dto
	        dto.id_entrenador = (String) fila.get("id");
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
