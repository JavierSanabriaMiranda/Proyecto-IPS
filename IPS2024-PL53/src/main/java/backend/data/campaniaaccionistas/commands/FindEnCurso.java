package backend.data.campaniaaccionistas.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import backend.data.Database;
import backend.data.DatabaseException;
import backend.data.campaniaaccionistas.CampaniaDTO;

public class FindEnCurso {
	
	private static final String QUERY = "SELECT * FROM CAMPANIA_ACCIONISTAS "
	        + "WHERE ESTADO = 'ABIERTA'";
	
	private Database db = new Database();

	public Optional<CampaniaDTO> execute() {
		List<Map<String, Object>> mapsCampania = db.executeQueryMap(QUERY);
		List<CampaniaDTO> campanias = mapsToCampania(mapsCampania);
		if (campanias.size() > 1) 
			throw new DatabaseException("La base de datos está inconsistente pues tiene más de una campaña "
					+ "de accionistas en curso a la vez");
		if (campanias.isEmpty())
			return Optional.empty();
		return Optional.of(campanias.get(0));
	}

	private List<CampaniaDTO> mapsToCampania(List<Map<String, Object>> listaMap) {
		List<CampaniaDTO> lista = new ArrayList<>();
	    
	    // Recorre cada mapa y convierte los datos en un objeto EmpleadoDTO.
	    for (Map<String, Object> fila : listaMap) {
	    	CampaniaDTO dto = new CampaniaDTO(); // Renombrado a dto
	        dto.codCampania = (String) fila.get("COD_CAMPANIA");
	        dto.accionesIniciales = (int) fila.get("NUMERO_ACCIONES_INICIALES");
	        dto.accionesRestantes = (int) fila.get("NUMERO_ACCIONES_RESTANTES");
	        dto.fase = (int) fila.get("FASE");
	        dto.estado = (String) fila.get("ESTADO");
	        
	        lista.add(dto);
	    }
	    return lista; 		
	}
}
