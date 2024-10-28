package backend.data.campaniaaccionistas;

import java.util.Optional;

import backend.data.accionistas.AccionistaDTO;
import backend.data.campaniaaccionistas.commands.AddAccionistaEnCampania;
import backend.data.campaniaaccionistas.commands.CrearCampania;
import backend.data.campaniaaccionistas.commands.FindAccionistaEnCampaniaByDni;
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

	@Override
	public Optional<AccionistaDTO> getAccionistaEnCampaniaByDni(String dniAccionista) {
		return new FindAccionistaEnCampaniaByDni(dniAccionista).execute();
	}

	@Override
	public void addAccionistaEnCampania(String idAccionista, String codCampania, int numAccionesIniciales) {
		new AddAccionistaEnCampania(idAccionista, codCampania, numAccionesIniciales).execute();
	}

}
