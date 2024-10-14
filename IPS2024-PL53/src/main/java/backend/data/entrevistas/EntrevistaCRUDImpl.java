package backend.data.entrevistas;

import java.util.Date;

import backend.data.entrevistas.commands.AddEntrevista;
import backend.data.entrevistas.commands.AddFranjaEntrevista;
import backend.data.entrevistas.commands.FindEntrevistaByDate;

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
	public void addFranjaEntrevista(FranjaEntrevistaDTO franja) {
		new AddFranjaEntrevista(franja).execute();
	}

}
