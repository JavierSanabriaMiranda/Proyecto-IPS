package backend.data.horarios;

import java.util.List;

import backend.data.horarios.commands.CargarTurnosPuntuales;
import backend.data.horarios.commands.CargarTurnosSemanales;

public class HorarioCRUDImpl implements HorarioCRUDService {

	@Override
	public List<TurnoSemanalDTO> cargarTurnosSemanales() {
		return new CargarTurnosSemanales().execute();
	}

	@Override
	public List<TurnoPuntualDTO> cargarTurnosPuntuales() {
		return new CargarTurnosPuntuales().execute();
	}

	
}
