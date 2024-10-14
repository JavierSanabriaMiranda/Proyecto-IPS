package backend.data.entrenamientos;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import backend.data.entrenamientos.commands.FindEntrenamientoByRangoHora;

public class EntrenamientoCRUDImpl implements EntrenamientoCRUDService {

	@Override
	public List<EntrenamientoDto> findEntrenamientoByRangoHora(Date fecha, Time inicio, Time fin) {
		return new FindEntrenamientoByRangoHora(fecha, inicio, fin).execute();
	}

	
}
