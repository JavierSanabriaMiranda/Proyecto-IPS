package backend.data.entrevistas;

import java.util.Date;
import java.util.List;

import backend.data.entrevistas.commands.AddEntrevista;
import backend.data.entrevistas.commands.AddFranjaEntrevista;
import backend.data.entrevistas.commands.DeleteEntrevistaYFranjaPorHora;
import backend.data.entrevistas.commands.DeleteFranjasByIdJugadorAndDate;
import backend.data.entrevistas.commands.FindEntrevistaByCod;
import backend.data.entrevistas.commands.FindEntrevistaByDate;
import backend.data.entrevistas.commands.FindEntrevistaByJugadorIdAndDate;
import backend.data.entrevistas.commands.FindFranjaByJugadorIdAndDate;
import backend.service.horarios.FranjaTiempo;
import backend.util.FranjaEntrevistaException;
import backend.util.log.LogManager;

public class EntrevistaCRUDImpl implements EntrevistaCRUDService {

	@Override
	public void addEntrevista(EntrevistaDTO entrevista) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: ENTREVISTA");
		new AddEntrevista(entrevista).execute();		
	}

	@Override
	public EntrevistaDTO findEntrevistaByDate(Date fecha) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: ENTREVISTA");
		return new FindEntrevistaByDate(fecha).execute();
	}

	@Override
	public void addFranjaEntrevista(FranjaEntrevistaDTO franja) throws FranjaEntrevistaException {
		LogManager.logAction("Modificación en Base de Datos. Tabla: FRANJA_ENTREVISTA");
		new AddFranjaEntrevista(franja).execute();
	}

	@Override
	public EntrevistaDTO findEntrevistaByJugadorIdAndDate(String idJugador, Date fecha) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: ENTREVISTA");
		return new FindEntrevistaByJugadorIdAndDate(idJugador, fecha).execute();
	}

	@Override
	public void deleteFranjasByIdJugadorAndDate(String idJugador, Date fecha) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: FRANJA_ENTREVISTA");
		new DeleteFranjasByIdJugadorAndDate(idJugador, fecha).execute();
	}

	@Override
	public List<FranjaEntrevistaDTO> findFranjaByJugadorIdAndDate(String idJugador, Date fecha) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: FRANJA_ENTREVISTA");
		return new FindFranjaByJugadorIdAndDate(idJugador, fecha).execute();
	}

	@Override
	public EntrevistaDTO findEntrevistaByCod(String cod) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: ENTREVISTA");
		return new FindEntrevistaByCod(cod).execute();
	}

	@Override
	public void deleteEntrevistaYFranjaPorHora(FranjaTiempo fra, String idJugador) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: FRANJA_ENTREVISTA, ENTREVISTA");
		new DeleteEntrevistaYFranjaPorHora(fra, idJugador).execute();
	}

}
