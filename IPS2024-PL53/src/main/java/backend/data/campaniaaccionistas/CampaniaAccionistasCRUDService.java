package backend.data.campaniaaccionistas;

import java.util.Optional;

public interface CampaniaAccionistasCRUDService {

	/**
	 * @return campania en curso
	 */
	Optional<CampaniaDTO> findEnCurso();

	void crearCampania(CampaniaDTO dto);
}
