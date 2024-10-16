package backend.data.equipos.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import backend.data.Database;
import backend.data.equipos.EquipoEnFormacionDto;

public class CargarEquiposEnFormacion {

private static final String SQL =  "SELECT * FROM EQUIPO_FORMACION";
            
	
	Database db = new Database();
	
	public List<EquipoEnFormacionDto> execute() {
		return mapsToEquipoEnFormacion(db.executeQueryMap(SQL));
	}

	private List<EquipoEnFormacionDto> mapsToEquipoEnFormacion(List<Map<String, Object>> listaMap) {
		List<EquipoEnFormacionDto> lista = new ArrayList<EquipoEnFormacionDto>();

		// Recorre cada mapa y convierte los datos en un objeto EquipoEnFormacionDto.
		for (Map<String, Object> fila : listaMap) {
			EquipoEnFormacionDto dto = new EquipoEnFormacionDto(); // Renombrado a dto
			dto.idEquipo = (String) fila.get("ID_EQUIPO");
			dto.categoria = (String) fila.get("CATEGORIA");
			
			lista.add(dto);
		}
		return lista;
	}
}
