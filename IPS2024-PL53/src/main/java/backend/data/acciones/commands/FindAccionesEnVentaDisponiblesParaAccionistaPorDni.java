package backend.data.acciones.commands;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import backend.data.Database;
import backend.data.DatabaseException;
import backend.data.acciones.AccionDTO;
import backend.data.accionistas.AccionistaDTO;
import backend.service.ventas.campanaAccionistas.Accion;

public class FindAccionesEnVentaDisponiblesParaAccionistaPorDni {

	private static final String QUERY = "SELECT * FROM ACCION WHERE ID_ACCIONISTA <> ? AND ISENVENTA";

	private String idAccionista;
	private Database db = new Database();

	public FindAccionesEnVentaDisponiblesParaAccionistaPorDni(String idAccionista) {
		if (idAccionista == null)
			throw new IllegalArgumentException("El dni no puede ser null");
		this.idAccionista = idAccionista;
	}

	public List<AccionDTO> execute() {
		List<Map<String, Object>> mapsAcciones = db.executeQueryMap(QUERY, idAccionista);
		List<AccionDTO> acciones = mapsToAccion(mapsAcciones);

		return acciones;
	}
	
	private List<AccionDTO> mapsToAccion(List<Map<String, Object>> listaMap) {
		List<AccionDTO> lista = new ArrayList<>();
	    
	    // Recorre cada mapa y convierte los datos en un objeto EmpleadoDTO.
	    for (Map<String, Object> fila : listaMap) {
	    	
	        String idAccion = (String) fila.get("ID_ACCION");
	        String idAccionista = (String) fila.get("ID_ACCIONISTA");
	        BigDecimal precioBig = (BigDecimal) fila.get("PRECIO");
	        float precio = precioBig.floatValue();
	        
	        
	        AccionDTO dto = new AccionDTO(idAccion, idAccionista, precio); // Renombrado a dto
	        
	        lista.add(dto);
	    }
	    return lista; 		
	}
}
