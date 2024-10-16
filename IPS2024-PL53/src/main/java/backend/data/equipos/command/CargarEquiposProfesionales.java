package backend.data.equipos.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import backend.data.Database;
import backend.data.equipos.EquipoProfesionalDto;

public class CargarEquiposProfesionales {
	
	private static final String SQL =  "SELECT * FROM EQUIPO_PROFESIONAL";
            
	
	Database db = new Database();
	
	public List<EquipoProfesionalDto> execute() {
		return mapsToEquipoProfesional(db.executeQueryMap(SQL));
	}

	private List<EquipoProfesionalDto> mapsToEquipoProfesional(List<Map<String, Object>> listaMap) {
		List<EquipoProfesionalDto> lista = new ArrayList<EquipoProfesionalDto>();

		// Recorre cada mapa y convierte los datos en un objeto EquipoProfesionalDto.
		for (Map<String, Object> fila : listaMap) {
			EquipoProfesionalDto dto = new EquipoProfesionalDto(); // Renombrado a dto
			dto.idEquipo = (String) fila.get("ID_EQUIPO");
			dto.equipoProfesionalDelQueEsFilial = (String) fila.get("ID_PROFESIONAL");
			
			lista.add(dto);
		}
		return lista;
	}

}
