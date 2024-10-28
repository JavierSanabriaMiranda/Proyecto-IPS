package backend.data.accionistas;

import java.util.Optional;

import backend.data.accionistas.commands.FindByDniAccionista;
import backend.data.accionistas.commands.GetNumAccionesByDniAccionista;

public class AccionistasCRUDImpl implements AccionistasCRUDService {

	@Override
	public Optional<AccionistaDTO> findByDniAccionista(String dni) {
		return new FindByDniAccionista(dni).execute();
	}

	@Override
	public int getNumAccionesByDniAccionista(String dniAccionista) {
		return new GetNumAccionesByDniAccionista(dniAccionista).execute();
	}

}
