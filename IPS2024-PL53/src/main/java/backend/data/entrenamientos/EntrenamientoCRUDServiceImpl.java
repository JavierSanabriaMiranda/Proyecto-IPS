package backend.data.entrenamientos;

import java.util.List;

import backend.data.entrenamientos.commands.CargarEntrenamientos;

public class EntrenamientoCRUDServiceImpl implements EntrenamientoCRUDService{

	@Override
	public List<EntrenamientoDto> cargarEntrenamientos() {
		return new CargarEntrenamientos().execute();
	}

}
