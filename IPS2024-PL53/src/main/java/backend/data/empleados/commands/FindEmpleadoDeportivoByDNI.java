package backend.data.empleados.commands;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import backend.data.Database;
import backend.data.empleados.EmpleadoDeportivoDTO;

public class FindEmpleadoDeportivoByDNI {

	private static final String QUERY = "SELECT * FROM EMPLEADO_DEPORTIVO WHERE DNI = ?";
	
	private String dni;
	private Database db = new Database();
	
	public FindEmpleadoDeportivoByDNI(String dni) {
		if (dni == null)
			throw new IllegalArgumentException("El dni no puede ser null");
		this.dni = dni;
	}

	public Optional<EmpleadoDeportivoDTO> execute() {
		List<Map<String, Object>> mapsEmpDeps =  db.executeQueryMap(QUERY, dni);
		if (mapsEmpDeps.isEmpty())
			return Optional.empty();
		return Optional.of(mapsToEmpleado(mapsEmpDeps).get(0));
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
