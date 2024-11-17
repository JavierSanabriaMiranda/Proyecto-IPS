package backend.data.asientos.commands;

import java.util.List;
import java.util.Map;

import backend.data.Database;
import backend.data.asientos.AsientoDTO;

public class FindAsientoEqual {
private static final String QUERY = "SELECT * FROM ASIENTO WHERE TRIBUNA=? AND SECCION=? AND N_FILA=? AND N_ASIENTO=?"; 
	
	private String tribuna;
	private String seccion;
	private String fila;
	private String asiento;
	private Database db = new Database();

	public FindAsientoEqual(String tribuna,String seccion,String fila,String asiento) {
		this.tribuna=tribuna;
		this.seccion=seccion;
		this.asiento=asiento;
		this.fila=fila;
	}

	public AsientoDTO execute() {
		List<Map<String, Object>> mapsAsientos = db.executeQueryMap(QUERY, tribuna,seccion,fila,asiento);
		
		return mapsToAsiento(mapsAsientos);
	}
	
	
	private AsientoDTO mapsToAsiento(List<Map<String, Object>> listaMap) {
		AsientoDTO dto = new AsientoDTO(); // Renombrado a dto
	    // Recorre cada mapa y convierte los datos en un objeto AsientoDTO.
	    for (Map<String, Object> fila : listaMap) {
	        dto.idAsiento = (String) fila.get("ID_ASIENTO");
	        dto.nAsiento = (int) fila.get("N_ASIENTO");
	        dto.nFila = (int) fila.get("N_FILA");
	        dto.seccion = (String) fila.get("SECCION");
	        dto.tribuna = (String) fila.get("TRIBUNA");
	    }
	    return dto; 		
	}

}
