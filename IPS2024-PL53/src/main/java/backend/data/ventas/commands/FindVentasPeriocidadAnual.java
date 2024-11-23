package backend.data.ventas.commands;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import backend.data.Database;
import backend.data.ventas.VentaDto;

public class FindVentasPeriocidadAnual {

	private static final String QUERY = "SELECT "
			+ "	EXTRACT(YEAR FROM FECHA) AS year,"
			+ " EXTRACT(MONTH FROM FECHA) AS mes,"
			+ " SUM(COSTE) AS total_coste "
			+ "FROM VENTAS WHERE EXTRACT(YEAR FROM FECHA)= ? "
			+ "GROUP BY"
			+ "	EXTRACT(YEAR FROM FECHA),"
			+ " EXTRACT(MONTH FROM FECHA)";
	
	private int year;
	private Database db = new Database();
	
	public FindVentasPeriocidadAnual(int year) {
		this.year = year;
	}

	public List<VentaDto> execute() {
	 	List<Map<String, Object>> ventas = db.executeQueryMap(QUERY, year);
	 	return mapsToVentas(ventas);
	}
	
	private List<VentaDto> mapsToVentas(List<Map<String, Object>> listaMap) {
		List<VentaDto> lista = new ArrayList<>();
	    
	    // Recorre cada mapa y convierte los datos en un objeto
	    for (Map<String, Object> fila : listaMap) {
	    	VentaDto dto = new VentaDto(); // Renombrado a dto
	        dto.year = (int) fila.get("year");
	        dto.mes = (int) fila.get("mes");
	        BigDecimal coste = (BigDecimal) fila.get("total_coste");
	        dto.coste = coste.floatValue();
	        
	        lista.add(dto);
	    }
	    return lista; 		
	}

}
