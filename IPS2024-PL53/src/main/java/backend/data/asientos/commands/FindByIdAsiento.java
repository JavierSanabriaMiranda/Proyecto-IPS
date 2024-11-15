package backend.data.asientos.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import backend.data.Database;
import backend.data.asientos.AsientoDTO;

public class FindByIdAsiento {
	
	private static final String QUERY = "SELECT * FROM ASIENTO WHERE ID_ASIENTO = ?"; 
	
	private String idAsiento;
	private Database db = new Database();

	public FindByIdAsiento(String idAsiento) {
		if (idAsiento == null)
			throw new IllegalArgumentException("El id no puede ser null");
		this.idAsiento = idAsiento;
	}

	public AsientoDTO execute() {
		List<Map<String, Object>> mapsAsientos = db.executeQueryMap(QUERY, idAsiento);
		
		return mapsToAsiento(mapsAsientos).get(0);
	}
	
	
	private List<AsientoDTO> mapsToAsiento(List<Map<String, Object>> listaMap) {
		List<AsientoDTO> lista = new ArrayList<>();
	    
	    // Recorre cada mapa y convierte los datos en un objeto AsientoDTO.
	    for (Map<String, Object> fila : listaMap) {
	    	AsientoDTO dto = new AsientoDTO(); // Renombrado a dto
	        dto.idAsiento = (String) fila.get("ID_ASIENTO");
	        dto.nAsiento = (int) fila.get("N_ASIENTO");
	        dto.nFila = (int) fila.get("N_FILA");
	        dto.seccion = (String) fila.get("SECCION");
	        dto.tribuna = (String) fila.get("TRIBUNA");
	        
	        lista.add(dto);
	    }
	    return lista; 		
	}


}
