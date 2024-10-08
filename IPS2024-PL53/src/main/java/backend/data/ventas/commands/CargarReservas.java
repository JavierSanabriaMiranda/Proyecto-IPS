package backend.data.ventas.commands;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import backend.data.Database;
import backend.data.ventas.ReservaDto;

public class CargarReservas {

	private static final String SQL = "SELECT * FROM RESERVA R INNER JOIN VENTAS V ON V.ID_VENTAS = R.COD_RESERVA INNER JOIN CLIENTE C ON C.DNI = V.DNI;";
	
	private Database db = new Database();
	
	public CargarReservas() {
		
	}
	
	public List<ReservaDto> execute() {
		return mapsToEntrenamiento(db.executeQueryMap(SQL));
	}
	
    private List<ReservaDto> mapsToEntrenamiento(List<Map<String, Object>> listaMap) {
        List<ReservaDto> lista = new ArrayList<ReservaDto>();
        
        // Recorre cada mapa y convierte los datos en un objeto ReservaDto.
        for (Map<String, Object> fila : listaMap) {
        	ReservaDto dto = new ReservaDto(); // Renombrado a dto
        	dto.codReserva = (String) fila.get("COD_RESERVA");
        	Time sqlTimeFin =  (Time) fila.get("HORA_FIN");
        	Time sqlTimeInicio =  (Time) fila.get("HORA_INICIO");
        	dto.horaInicio = new Date(sqlTimeInicio.getTime());
        	dto.horaFin = new Date(sqlTimeFin.getTime());
        	dto.nombreCliente = (String) fila.get("NOMBRE");
        	dto.codInstalacion = (String) fila.get("COD_INSTALACION");
        	dto.numTarjeta = (String) fila.get("N_TARJETA");
        	dto.DNI = (String) fila.get("DNI");
        	dto.fecha = (Date) fila.get("FECHA");
        	
        	// Los valores "Decimal" de la base de datos se traen a java como BigDecimal por lo que
            // es necesaria una conversión a double
            BigDecimal coste = (BigDecimal) fila.get("COSTE");
            if (coste != null) {
                dto.coste = coste.floatValue(); // Asigna el valor convertido a salarioAnual
            } else {
                dto.coste = 0; // Asigna 0.0 si salarioAnualBD es null
            }
        	
            lista.add(dto);
        }
        return lista;         
    }
}
