package backend.data.horarios;

import java.util.List;

import backend.data.horarios.commands.AddTurnoPuntual;
import backend.data.horarios.commands.AddTurnoSemanal;
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

	@Override
	public void addTurnoSemanal(TurnoSemanalDTO dto) {
		new AddTurnoSemanal(dto).execute();
	}

	@Override
	public void addTurnoPuntual(TurnoPuntualDTO dto) {
		new AddTurnoPuntual(dto).execute();
	}

	
}
