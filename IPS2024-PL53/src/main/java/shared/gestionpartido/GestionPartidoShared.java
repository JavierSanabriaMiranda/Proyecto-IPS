package shared.gestionpartido;

import java.util.List;

import backend.data.CreadorDataService;
import backend.data.partidos.PartidoDTO;
import backend.data.partidos.PartidosCRUDService;

public class GestionPartidoShared {

	public String[] getTodosPartidos() {
		PartidosCRUDService service = CreadorDataService.getPartidosService();
		List<PartidoDTO> partidos = service.findAllPartidos();
		
		String[] res = new String[partidos.size()];
		for (int i = 0 ; i < partidos.size() ; i++) {
			res[i] = partidos.get(i).fecha + "/" + partidos.get(i).horaInicio + "/" + partidos.get(i).horaFin;
		}
		return res;
	}
	
	public String getIdPartidoByFechaInicioFin(String fecha, String inicio, String fin) {
		PartidosCRUDService service = CreadorDataService.getPartidosService();
		return service.findIdByFechaInicioFin(fecha, inicio, fin);
	}
}
