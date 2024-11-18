package backend.data.horarios;

import java.util.List;

import backend.data.horarios.commands.AddTurnoPuntual;
import backend.data.horarios.commands.AddTurnoSemanal;
import backend.data.horarios.commands.CargarTurnosPuntuales;
import backend.data.horarios.commands.CargarTurnosSemanales;
import backend.util.log.LogManager;

public class HorarioCRUDImpl implements HorarioCRUDService {

	@Override
	public List<TurnoSemanalDTO> cargarTurnosSemanales() {
		LogManager.logAction("Acceso a Base de Datos. Tabla: TURNO_SEMANAL, TURNO");
		return new CargarTurnosSemanales().execute();
	}

	@Override
	public List<TurnoPuntualDTO> cargarTurnosPuntuales() {
		LogManager.logAction("Acceso a Base de Datos. Tabla: TURNO_PUNTUAL, TURNO");
		return new CargarTurnosPuntuales().execute();
	}

	@Override
	public void addTurnoSemanal(TurnoSemanalDTO dto) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: TURNO_SEMANAL, TURNO");
		new AddTurnoSemanal(dto).execute();
	}

	@Override
	public void addTurnoPuntual(TurnoPuntualDTO dto) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: TURNO_PUNTUAL, TURNO");
		new AddTurnoPuntual(dto).execute();
	}

	
}
