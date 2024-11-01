package backend.data.entrenamientos;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import backend.data.entrenamientos.commands.AddEntrenamiento;
import backend.data.entrenamientos.commands.CargarEntrenamientos;
import backend.data.entrenamientos.commands.FindEntrenamientoByIdEquipoRangoHora;

public class EntrenamientoCRUDImpl implements EntrenamientoCRUDService {

	@Override
	public List<EntrenamientoDto> findEntrenamientoByIdEquipoRangoHora(String idEquipo, Date fecha, Time inicio, Time fin) {
		return new FindEntrenamientoByIdEquipoRangoHora(idEquipo, fecha, inicio, fin).execute();
	}
	
	@Override
	public List<EntrenamientoDto> cargarEntrenamientos() {
		return new CargarEntrenamientos().execute();
	}

	@Override
	public void addEntrenamiento(EntrenamientoDto dto) {
		new AddEntrenamiento(dto).execute();
	}
	
}
