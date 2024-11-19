package backend.data.accionistas.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import backend.data.Database;
import backend.data.accionistas.AccionistaDTO;

public class FindByIdAccionista {

	private static final String QUERY = "SELECT * FROM ACCIONISTA WHERE ID_ACCIONISTA = ?";
	
	private String id;
	private Database db = new Database();
	
	public FindByIdAccionista(String id) {
		if (id == null)
			throw new IllegalArgumentException("El id no puede ser null");
		this.id = id;
	}

	public Optional<AccionistaDTO> execute() {
		List<Map<String, Object>> mapsAccionista = db.executeQueryMap(QUERY, id);
		List<AccionistaDTO> accionistas = mapsToAccionista(mapsAccionista);
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
