package shared.gestionpartido;

import java.util.Date;
import java.util.List;

import backend.data.CreadorDataService;
import backend.data.partidos.PartidoDTO;
import backend.data.partidos.PartidosCRUDService;

public class GestionPartidoShared {

	public Date[][] getTodosPartidos() {
		PartidosCRUDService service = CreadorDataService.getPartidosService();
		List<PartidoDTO> partidos = service.findAllPartidos();
		
		Date[][] partidosFechas = new Date[partidos.size()][3];
		
		for (int i = 0 ; i < partidos.size() ; i++) {
			partidosFechas[i][0] = partidos.get(i).fecha; 
			partidosFechas[i][1] = partidos.get(i).horaInicio; 
			partidosFechas[i][2] = partidos.get(i).horaFin; 
			
		}
		return partidosFechas;
	}
	
	public String getIdPartidoByFechaInicioFin(String fecha, String inicio, String fin) {
		PartidosCRUDService service = CreadorDataService.getPartidosService();
		return service.findIdByFechaInicioFin(fecha, inicio, fin);
	}
}
