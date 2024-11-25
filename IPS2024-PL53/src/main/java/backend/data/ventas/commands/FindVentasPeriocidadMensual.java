package backend.data.ventas.commands;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import backend.data.Database;
import backend.data.ventas.VentaDto;

public class FindVentasPeriocidadMensual {

	private static final String QUERY = "SELECT "
			+ "	EXTRACT(DAY FROM FECHA) AS dia,"
			+ " SUM(COSTE) AS total_coste "
			+ "FROM VENTAS "
			+ "WHERE "
			+ "	EXTRACT(YEAR FROM FECHA)= ? AND"
			+ " EXTRACT(MONTH FROM FECHA)= ? "
			+ "GROUP BY"
			+ "	EXTRACT(DAY FROM FECHA)";
	
	private int mes;
	private int year;
	private Database db = new Database();
	
	public FindVentasPeriocidadMensual(int mes, int year) {
		this.mes = mes;
		this.year = year;
	}

	public List<VentaDto> execute() {
	 	List<Map<String, Object>> ventas = db.executeQueryMap(QUERY, year, mes);
	 	return mapsToVentas(ventas);
	}
	
	private List<VentaDto> mapsToVentas(List<Map<String, Object>> listaMap) {
		List<VentaDto> lista = new ArrayList<>();
	    
	    // Recorre cada mapa y convierte los datos en un objeto
	    for (Map<String, Object> fila : listaMap) {
	    	VentaDto dto = new VentaDto(); // Renombrado a dto
	        dto.year = year;
	        dto.mes = mes;
	        dto.dia = (int) fila.get("dia");
	        BigDecimal coste = (BigDecimal) fila.get("total_coste");
	        dto.coste = coste.floatValue();
	        
	        lista.add(dto);
	    }
	    return lista; 		
	}

}
