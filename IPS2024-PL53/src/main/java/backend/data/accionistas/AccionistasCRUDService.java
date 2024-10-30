package backend.data.accionistas;

import java.util.Optional;

public interface AccionistasCRUDService {

	Optional<AccionistaDTO> findByDniAccionista(String dni);

	int getNumAccionesByDniAccionista(String dniAccionista);

	void addNuevoAccionista(AccionistaDTO dto);

}
