package backend.data.accionistas.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import backend.data.Database;
import backend.data.DatabaseException;
import backend.data.accionistas.AccionistaDTO;
import backend.data.campaniaaccionistas.CampaniaDTO;

public class FindByDniAccionista {
	
	private static final String QUERY = "SELECT * FROM ACCIONISTA WHERE DNI = ?";
	
	private Database db = new Database();
	private String dni;

	public FindByDniAccionista(String dni) {
		if (dni == null)
			throw new IllegalArgumentException("El dni no puede ser null");
		this.dni = dni;
	}

	public Optional<AccionistaDTO> execute() {
		List<Map<String, Object>> mapsAccionista = db.executeQueryMap(QUERY, dni);
		List<AccionistaDTO> accionistas = mapsToAccionista(mapsAccionista);
		if (accionistas.size() > 1) 
			throw new DatabaseException("La base de datos está en un estado inconsistente "
					+ "al haber más de un accionista con el mismo DNI");
		if (accionistas.isEmpty())
			return Optional.empty();
		return Optional.of(accionistas.get(0));
	}
	
	private List<AccionistaDTO> mapsToAccionista(List<Map<String, Object>> listaMap) {
		List<AccionistaDTO> lista = new ArrayList<>();
	    
	    // Recorre cada mapa y convierte los datos en un objeto EmpleadoDTO.
	    for (Map<String, Object> fila : listaMap) {
	    	AccionistaDTO dto = new AccionistaDTO(); // Renombrado a dto
	        dto.idAccionista = (String) fila.get("ID_ACCIONISTA");
	        dto.dniAccionista = (String) fila.get("DNI");
	        dto.nombreAccionista = (String) fila.get("NOMBRE");
	        
	        lista.add(dto);
	    }
	    return lista; 		
	}

}
