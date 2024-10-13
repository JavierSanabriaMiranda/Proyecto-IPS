package backend.data.horarios;

import java.util.List;

public interface HorarioCRUDService {
	
	List<TurnoSemanalDTO> cargarTurnosSemanales();
	List<TurnoPuntualDTO> cargarTurnosPuntuales();
}
