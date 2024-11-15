package backend.data.campaniaaccionistas;

import java.util.Optional;

import backend.data.accionistas.AccionistaDTO;
import backend.data.campaniaaccionistas.commands.AddAccionistaEnCampania;
import backend.data.campaniaaccionistas.commands.AddCampania;
import backend.data.campaniaaccionistas.commands.FindAccionistaEnCampaniaByDni;
import backend.data.campaniaaccionistas.commands.FindEnCurso;
import backend.data.campaniaaccionistas.commands.FindPrecioCampania;
import backend.data.campaniaaccionistas.commands.UpdateAccionistaEnCampania;
import backend.data.campaniaaccionistas.commands.UpdateCampania;

public class CampaniaAccionistasCRUDImpl implements CampaniaAccionistasCRUDService {

	@Override
	public Optional<CampaniaDTO> findEnCurso() {
		return new FindEnCurso().execute();
	}

	@Override
	public void crearCampania(CampaniaDTO dto) {
		new AddCampania(dto).execute();
	}

	@Override
	public void actualizarCampania(CampaniaDTO dto) {
		new UpdateCampania(dto).execute();
	}

	@Override
	public Optional<AccionistaEnCampaniaDTO> getAccionistaEnCampaniaByDni(String dniAccionista, String codCampania) {
		return new FindAccionistaEnCampaniaByDni(dniAccionista, codCampania).execute();
	}

	@Override
	public void addAccionistaEnCampania(String idAccionista, String codCampania, int numAccionesIniciales) {
		new AddAccionistaEnCampania(idAccionista, codCampania, numAccionesIniciales).execute();
	}

	@Override
	public void actualizarAccionistaEnCampania(AccionistaEnCampaniaDTO dtoAccCamp) {
		new UpdateAccionistaEnCampania(dtoAccCamp).execute();
	}

	@Override
	public float getPrecioTotal(String codigoCampania) {
		return new FindPrecioCampania(codigoCampania).execute();
	}

}
