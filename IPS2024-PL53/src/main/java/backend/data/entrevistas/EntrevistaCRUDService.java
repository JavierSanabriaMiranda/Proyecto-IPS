package backend.data.entrevistas;

import java.util.Date;
import java.util.List;

import backend.util.FranjaEntrevistaException;

public interface EntrevistaCRUDService {

	void addEntrevista(EntrevistaDTO entrevista);
	EntrevistaDTO findEntrevistaByDate(Date fecha);
	void addFranjaEntrevista(FranjaEntrevistaDTO franja) throws FranjaEntrevistaException;
	EntrevistaDTO findEntrevistaByJugadorIdAndDate(String idJugador, Date fecha);
	void deleteFranjasByIdJugadorAndDate(String idJugador, Date fecha);
	List<FranjaEntrevistaDTO> findFranjaByJugadorIdAndDate(String idJugador, Date fecha);
	EntrevistaDTO findEntrevistaByCod(String cod);
}
