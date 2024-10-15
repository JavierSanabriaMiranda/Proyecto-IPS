package backend.data.entrevistas;

import java.util.Date;

import backend.util.FranjaEntrevistaException;

public interface EntrevistaCRUDService {

	void addEntrevista(EntrevistaDTO entrevista);
	EntrevistaDTO findEntrevistaByDate(Date fecha);
	void addFranjaEntrevista(FranjaEntrevistaDTO franja) throws FranjaEntrevistaException;
	EntrevistaDTO findEntrevistaByJugadorIdAndDate(String idJugador, Date fecha);
}
