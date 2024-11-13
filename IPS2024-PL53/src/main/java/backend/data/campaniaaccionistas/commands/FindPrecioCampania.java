package backend.data.campaniaaccionistas.commands;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import backend.data.Database;

public class FindPrecioCampania {
 
	private static final String QUERY = "SELECT COSTE FROM VENTAS WHERE ID_VENTAS = ?";
	
	private String idCampania;
	private Database db = new Database();
	
	public FindPrecioCampania(String idCampania) {
		this.idCampania = idCampania;
	}
	
	public float execute() {
		List<Map<String, Object>> mapsCampania = db.executeQueryMap(QUERY, idCampania);
		return mapsToPrecio(mapsCampania);
	}
	
	private float mapsToPrecio(List<Map<String, Object>> listaMap) {
	    float precio = 0;
		
		// Recorre cada mapa y convierte los datos en un objeto EmpleadoDTO.
	    for (Map<String, Object> fila : listaMap) {
	    	BigDecimal precioBig = (BigDecimal) fila.get("COSTE");
	    	precio += precioBig.floatValue();
	    }
	    return precio; 		
	}
}
