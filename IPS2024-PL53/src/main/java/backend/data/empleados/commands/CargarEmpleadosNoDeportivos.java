package backend.data.empleados.commands;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import backend.data.Database;
import backend.data.empleados.EmpleadoDTO;

public class CargarEmpleadosNoDeportivos {
	
	private static final String QUERY = "SELECT "
	        + "ID_EMPLEADO_NO_DEP AS id, "
	        + "DNI AS DNI, "
	        + "NOMBRE AS nombre, "
	        + "APELLIDO AS apellido, "
	        + "TELEFONO AS telefono, "
	        + "FECHA_NACIMIENTO AS fechaNac, "
	        + "SALARIO_ANUAL AS salarioAnual, "
	        + "POSICION AS posicion "
	        + "FROM EMPLEADO_NO_DEPORTIVO";

	private Database db = new Database();
	
	public List<EmpleadoDTO> execute() {
		List<Map<String, Object>> mapsEmpleados = db.executeQueryMap(QUERY);
		List<EmpleadoDTO> empleados = mapsToEmpleado(mapsEmpleados);
		
		return empleados;
	}
	
	private List<EmpleadoDTO> mapsToEmpleado(List<Map<String, Object>> listaMap) {
		List<EmpleadoDTO> lista = new ArrayList<>();
	    
	    // Recorre cada mapa y convierte los datos en un objeto EmpleadoDTO.
	    for (Map<String, Object> fila : listaMap) {
	        EmpleadoDTO dto = new EmpleadoDTO(); // Renombrado a dto
	        dto.id = (String) fila.get("id");
	        dto.DNI = (String) fila.get("DNI");
	        dto.nombre = (String) fila.get("nombre");
	        dto.apellido = (String) fila.get("apellido");
	        dto.telefono = (String) fila.get("telefono");
	        dto.fechaNac = (Date) fila.get("fechaNac");
	        dto.posicion = (String) fila.get("posicion");
	        
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
