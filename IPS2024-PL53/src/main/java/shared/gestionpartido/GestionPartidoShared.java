package shared.gestionpartido;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import backend.data.CreadorDataService;
import backend.data.partidos.PartidoDTO;
import backend.data.partidos.PartidosCRUDService;

public class GestionPartidoShared {
	
	PartidosCRUDService service = CreadorDataService.getPartidosService();
	
	private List<PartidoDTO> getPartidosDentroRangoHoras(String idEquipo, Date fecha, Time inicio, Time fin) {
		return service.findPartidoByIdEquipoRangoHora(idEquipo, fecha, inicio, fin);
	}
	
	public boolean checkExistePartidoRangoHora(String idEquipo, Date fecha, Time inicio, Time fin) {
		return getPartidosDentroRangoHoras(idEquipo, fecha, inicio, fin).size() > 0;
	}
}
