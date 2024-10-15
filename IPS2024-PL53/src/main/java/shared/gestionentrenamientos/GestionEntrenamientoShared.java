package shared.gestionentrenamientos;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import backend.data.CreadorDataService;
import backend.data.entrenamientos.EntrenamientoCRUDService;
import backend.data.entrenamientos.EntrenamientoDto;

public class GestionEntrenamientoShared {
	
	EntrenamientoCRUDService servicio = CreadorDataService.getEntrenamientoService();
	
	private List<EntrenamientoDto> getEntrenamientosDentroRangoHoras(String idEquipo, Date fecha, Time inicio, Time fin) {
		List<EntrenamientoDto> res = servicio.findEntrenamientoByIdEquipoRangoHora(idEquipo, fecha, inicio, fin);
		return res;
	}
	
	
	public boolean checkExisteEntrenamientoRangoHora(String idEquipo, Date fecha, Time inicio, Time fin) {
		return getEntrenamientosDentroRangoHoras(idEquipo, fecha, inicio, fin).size() > 0;
	}

}
