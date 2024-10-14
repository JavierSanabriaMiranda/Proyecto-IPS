package backend.data.entrevistas;

import java.util.Date;

public interface EntrevistaCRUDService {

	void addEntrevista(EntrevistaDTO entrevista);
	EntrevistaDTO findEntrevistaByDate(Date fecha);
	
	void addFranjaEntrevista(FranjaEntrevistaDTO franja);
}
