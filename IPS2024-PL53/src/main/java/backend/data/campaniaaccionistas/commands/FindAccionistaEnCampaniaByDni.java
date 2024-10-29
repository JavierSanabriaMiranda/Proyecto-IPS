package backend.data.campaniaaccionistas.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import backend.data.Database;
import backend.data.DatabaseException;
import backend.data.accionistas.AccionistaDTO;
import backend.data.campaniaaccionistas.AccionistaEnCampaniaDTO;

public class FindAccionistaEnCampaniaByDni {
	
	private static final String QUERY = "SELECT * FROM PARTICIPA_EN_CAMPANIA P "
			+ "INNER JOIN ACCIONISTA A ON A.ID_ACCIONISTA = P.ID_ACCIONISTA WHERE P.ID_ACCIONISTA = ?";

	private Database db = new Database();
	private String dni;
	
	public FindAccionistaEnCampaniaByDni(String dni) {
		if (dni == null) 
			throw new IllegalArgumentException("El dni no puede ser null");
		this.dni = dni;
	}
	
	public Optional<AccionistaEnCampaniaDTO> execute() {
		List<Map<String, Object>> mapsAccionista = db.executeQueryMap(QUERY, dni);
		List<AccionistaEnCampaniaDTO> accionistas = mapsToAccionista(mapsAccionista);
		if (accionistas.size() > 1) 
			throw new DatabaseException("La base de datos está en un estado inconsistente "
					+ "al haber más de un accionista con el mismo DNI");
		if (accionistas.isEmpty())
			return Optional.empty();
		return Optional.of(accionistas.get(0));
	}
	
	private List<AccionistaEnCampaniaDTO> mapsToAccionista(List<Map<String, Object>> listaMap) {
		List<AccionistaEnCampaniaDTO> lista = new ArrayList<>();
	    
	    // Recorre cada mapa y convierte los datos en un objeto EmpleadoDTO.
	    for (Map<String, Object> fila : listaMap) {
	    	AccionistaEnCampaniaDTO dto = new AccionistaEnCampaniaDTO(); // Renombrado a dto
	        dto.idAccionista = (String) fila.get("ID_ACCIONISTA");
	        dto.codCampania = (String) fila.get("COD_CAMPANIA");
	        dto.numAccionesIniciales = (int) fila.get("NUM_ACCIONES_INICIALES");
	        dto.numAccionesCompradas = (int) fila.get("NUM_ACCIONES_COMPRADAS");
	        
	        lista.add(dto);
	    }
	    return lista; 		
	}
}
