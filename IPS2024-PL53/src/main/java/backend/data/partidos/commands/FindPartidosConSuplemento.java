package backend.data.partidos.commands;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import backend.data.Database;
import backend.data.partidos.PartidoDTO;

public class FindPartidosConSuplemento {
	
	private static final String QUERY = "SELECT * FROM PARTIDO WHERE TIENESUPLEMENTO";
	
	private Database db = new Database();

	public List<PartidoDTO> execute() {
		return mapsToPartidosConSup(db.executeQueryMap(QUERY));
	}

	private List<PartidoDTO> mapsToPartidosConSup(List<Map<String, Object>> listaMap) {
		List<PartidoDTO> lista = new ArrayList<PartidoDTO>();

		// Recorre cada mapa y convierte los datos en un objeto PartidoDTO.
		for (Map<String, Object> fila : listaMap) {
			PartidoDTO dto = new PartidoDTO(); 
			dto.idEquipo = (String) fila.get("ID_EQUIPO");
			dto.id = (String) fila.get("ID_PARTIDO");
			dto.fecha = (Date) fila.get("FECHA");
			Time sqlTimeFin =  (Time) fila.get("HORA_FIN");
        	Time sqlTimeInicio =  (Time) fila.get("HORA_INICIO");
        	dto.horaInicio = new Date(sqlTimeInicio.getTime());
        	dto.horaFin = new Date(sqlTimeFin.getTime());
			dto.visitante = (String) fila.get("VISITANTE");
			dto.tieneSuplemento = (boolean) fila.get("TIENESUPLEMENTO");
			
			lista.add(dto);
		}
		return lista;
	}

}
