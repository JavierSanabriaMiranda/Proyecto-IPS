package backend.data.entrenamientos.commands;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import backend.data.Database;
import backend.data.entrenamientos.EntrenamientoDto;

public class CargarEntrenamientos {

	private static final String SQL = "SELECT * FROM ENTRENAMIENTO";
	
	private Database db = new Database();
	
	public CargarEntrenamientos() {
		
	}
	
	public List<EntrenamientoDto> execute() {
		return mapsToEntrenamiento(db.executeQueryMap(SQL));
	}
	
    private List<EntrenamientoDto> mapsToEntrenamiento(List<Map<String, Object>> listaMap) {
        List<EntrenamientoDto> lista = new ArrayList<EntrenamientoDto>();
        
        // Recorre cada mapa y convierte los datos en un objeto EntrenamientoDto.
        for (Map<String, Object> fila : listaMap) {
        	EntrenamientoDto dto = new EntrenamientoDto(); // Renombrado a dto
            dto.idEntrenamiento = (String) fila.get("ID_ENTRENAMIENTO");
            dto.fecha = (Date) fila.get("FECHA");
            Time sqlTimeFin =  (Time) fila.get("HORA_FIN");
        	Time sqlTimeInicio =  (Time) fila.get("HORA_INICIO");
        	dto.horaInicio = new Date(sqlTimeInicio.getTime());
        	dto.horaFinal = new Date(sqlTimeFin.getTime());
            dto.codInstalacion = (String) fila.get("COD_INSTALACION");
            dto.idEquipo = (String) fila.get("ID_EQUIPO");
  
            lista.add(dto);
        }
        return lista;         
    }
}
