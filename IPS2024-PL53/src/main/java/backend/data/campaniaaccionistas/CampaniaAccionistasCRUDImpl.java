package backend.data.campaniaaccionistas;

import java.util.Optional;

import backend.data.campaniaaccionistas.commands.CrearCampania;
import backend.data.campaniaaccionistas.commands.FindEnCurso;
import backend.data.campaniaaccionistas.commands.UpdateCampania;

public class CampaniaAccionistasCRUDImpl implements CampaniaAccionistasCRUDService {

	@Override
	public Optional<CampaniaDTO> findEnCurso() {
		return new FindEnCurso().execute();
	}

	@Override
	public void crearCampania(CampaniaDTO dto) {
		new CrearCampania(dto).execute();
	}

	@Override
	public void actualizarCampania(CampaniaDTO dto) {
		new UpdateCampania(dto).execute();
	}

}
