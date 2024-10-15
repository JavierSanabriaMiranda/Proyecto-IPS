package backend.data.entrevistas;

import java.util.Date;

import backend.data.entrevistas.commands.AddEntrevista;
import backend.data.entrevistas.commands.AddFranjaEntrevista;
import backend.data.entrevistas.commands.FindEntrevistaByDate;
import backend.data.entrevistas.commands.FindEntrevistaByJugadorIdAndDate;
import backend.util.FranjaEntrevistaException;

public class EntrevistaCRUDImpl implements EntrevistaCRUDService {

	@Override
	public void addEntrevista(EntrevistaDTO entrevista) {
		new AddEntrevista(entrevista).execute();		
	}

	@Override
	public EntrevistaDTO findEntrevistaByDate(Date fecha) {
		return new FindEntrevistaByDate(fecha).execute();
	}

	@Override
	public void addFranjaEntrevista(FranjaEntrevistaDTO franja) throws FranjaEntrevistaException {
		new AddFranjaEntrevista(franja).execute();
	}

	@Override
	public EntrevistaDTO findEntrevistaByJugadorIdAndDate(String idJugador, Date fecha) {
		return new FindEntrevistaByJugadorIdAndDate(idJugador, fecha).execute();
	}

}
