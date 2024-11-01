package backend.data.reservaJardineria.commands;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import backend.data.Database;
import backend.data.reservaJardineria.ReservaJardineriaDTO;

public class CargarReservasJardineria {
private static final String SQL = "SELECT * FROM RESERVA_JARDINERIA";


	
	private Database db = new Database();
	
	public CargarReservasJardineria() {
		
	}
	
	public List<ReservaJardineriaDTO> execute() {
		List<Map<String, Object>> listaMap = db.executeQueryMap(SQL);
		return mapsToReserva(listaMap);
	}
	
    private List<ReservaJardineriaDTO> mapsToReserva(List<Map<String, Object>> listaMap) {
        List<ReservaJardineriaDTO> lista = new ArrayList<ReservaJardineriaDTO>();
        
        // Recorre cada mapa y convierte los datos en un objeto ReservaJardineriaDTO.
        for (Map<String, Object> fila : listaMap) {
        	ReservaJardineriaDTO dto = new ReservaJardineriaDTO(); // Renombrado a dto
        	dto.codReservaJardineria = (String) fila.get("COD_RESERVA_JARDINERIA");
        	Time sqlTimeFin =  (Time) fila.get("HORA_FIN");
        	Time sqlTimeInicio =  (Time) fila.get("HORA_INICIO");
        	dto.horaInicio = new Date(sqlTimeInicio.getTime());
        	dto.horaFin = new Date(sqlTimeFin.getTime());
        	dto.idJardinero = (String) fila.get("ID_JARDINERO");
        	dto.codInstalacion = (String) fila.get("COD_INSTALACION");
        	dto.fecha = (Date) fila.get("FECHA");

            lista.add(dto);
        }
        return lista;         
    }
}
