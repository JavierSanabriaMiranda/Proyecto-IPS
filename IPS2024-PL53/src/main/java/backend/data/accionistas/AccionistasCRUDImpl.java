package backend.data.accionistas;

import java.util.Optional;

import backend.data.accionistas.commands.FindByDniAccionista;

public class AccionistasCRUDImpl implements AccionistasCRUDService {

	@Override
	public Optional<AccionistaDTO> findByDniAccionista(String dni) {
		return new FindByDniAccionista(dni).execute();
	}

}
