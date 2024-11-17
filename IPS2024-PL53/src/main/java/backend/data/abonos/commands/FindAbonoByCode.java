package backend.data.abonos.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import backend.data.Database;
import backend.data.DatabaseException;
import backend.data.abonos.AbonoDTO;

public class FindAbonoByCode {
	
	private static final String QUERY = "SELECT * FROM ABONO_TEMPORADA WHERE CODABONO = ?";
	
	private Database db = new Database();
	private String cod;
	
	public FindAbonoByCode(String cod) {
		this.cod = cod;
	}

	public Optional<AbonoDTO> execute() {
		List<Map<String, Object>> mapsAbonos = db.executeQueryMap(QUERY, cod);
		List<AbonoDTO> abonos = mapsToAccionista(mapsAbonos);
		if (abonos.size() > 1) 
			throw new DatabaseException("La base de datos está en un estado inconsistente "
					+ "al haber más de un abono con el mismo codigo");
		if (abonos.isEmpty())
			return Optional.empty();
		return Optional.of(abonos.get(0));
	}
	
	private List<AbonoDTO> mapsToAccionista(List<Map<String, Object>> listaMap) {
		List<AbonoDTO> lista = new ArrayList<>();
	    
	    // Recorre cada mapa y convierte los datos en un objeto AbonoDTO.
	    for (Map<String, Object> fila : listaMap) {
	    	AbonoDTO dto = new AbonoDTO(); // Renombrado a dto
	        dto.codAbono = (String) fila.get("CODABONO");
	        dto.idAsiento = (String) fila.get("ID_ASIENTO");
	        
	        lista.add(dto);
	    }
	    return lista; 		
	}

}
