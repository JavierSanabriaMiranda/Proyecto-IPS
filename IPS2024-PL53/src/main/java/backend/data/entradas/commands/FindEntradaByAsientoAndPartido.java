package backend.data.entradas.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import backend.data.Database;
import backend.data.DatabaseException;
import backend.data.entradas.EntradaDTO;

public class FindEntradaByAsientoAndPartido {
	
	
	private static final String QUERY = "SELECT * FROM ENTRADA WHERE ID_PARTIDO = ? AND ID_ASIENTO = ?";
	
	private String idAsiento;
	private String idPartido;
	private Database db = new Database();

	public FindEntradaByAsientoAndPartido(String idAsiento, String idPartido) {
		this.idAsiento = idAsiento;
		this.idPartido = idPartido;
	}

	public Optional<EntradaDTO> execute() {
		List<Map<String, Object>> mapsEntradas = db.executeQueryMap(QUERY, idPartido, idAsiento);
		List<EntradaDTO> entradas = mapsToEntrada(mapsEntradas);
		if (entradas.size() > 1) 
			throw new DatabaseException("La base de datos está en un estado inconsistente "
					+ "al haber más de una entrada con el mismo id");
		if (entradas.isEmpty())
			return Optional.empty();
		return Optional.of(entradas.get(0));
	}
	
	private List<EntradaDTO> mapsToEntrada(List<Map<String, Object>> listaMap) {
		List<EntradaDTO> lista = new ArrayList<>();
	    
	    // Recorre cada mapa y convierte los datos en un objeto EntradaDTO.
	    for (Map<String, Object> fila : listaMap) {
	    	EntradaDTO dto = new EntradaDTO(); // Renombrado a dto
	        dto.idPartido = (String) fila.get("ID_PARTIDO");
	        dto.idAsiento = (String) fila.get("ID_ASIENTO");
	        
	        lista.add(dto);
	    }
	    return lista; 		
	}

}
