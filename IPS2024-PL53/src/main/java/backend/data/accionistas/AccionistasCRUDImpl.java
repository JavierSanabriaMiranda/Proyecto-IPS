package backend.data.accionistas;

import java.util.Optional;

import backend.data.accionistas.commands.AddAccionista;
import backend.data.accionistas.commands.FindByDniAccionista;
import backend.data.accionistas.commands.FindByIdAccionista;
import backend.data.accionistas.commands.GetNumAccionesByDniAccionista;
import backend.util.log.LogManager;

public class AccionistasCRUDImpl implements AccionistasCRUDService {

	@Override
	public Optional<AccionistaDTO> findByDniAccionista(String dni) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: ACCIONISTA");
		return new FindByDniAccionista(dni).execute();
	}

	@Override
	public int getNumAccionesByDniAccionista(String dniAccionista) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: ACCIONISTA");
		return new GetNumAccionesByDniAccionista(dniAccionista).execute();
	}

	@Override
	public void addNuevoAccionista(AccionistaDTO dto) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: ACCIONISTA");
		new AddAccionista(dto).execute();
	}

	@Override
	public Optional<AccionistaDTO> findByIdAccionista(String id) {
		return new FindByIdAccionista(id).execute();
	}

}
