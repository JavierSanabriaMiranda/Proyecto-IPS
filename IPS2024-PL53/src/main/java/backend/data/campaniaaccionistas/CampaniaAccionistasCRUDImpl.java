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
import backend.util.log.LogManager;

public class CampaniaAccionistasCRUDImpl implements CampaniaAccionistasCRUDService {

	@Override
	public Optional<CampaniaDTO> findEnCurso() {
		LogManager.logAction("Acceso a Base de Datos. Tabla: CAMPANIA_ACCIONISTAS");
		return new FindEnCurso().execute();
	}

	@Override
	public void crearCampania(CampaniaDTO dto) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: CAMPANIA_ACCIONISTAS");
		new AddCampania(dto).execute();
	}

	@Override
	public void actualizarCampania(CampaniaDTO dto) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: CAMPANIA_ACCIONISTAS");
		new UpdateCampania(dto).execute();
	}

	@Override
	public Optional<AccionistaEnCampaniaDTO> getAccionistaEnCampaniaByDni(String dniAccionista, String codCampania) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: CAMPANIA_ACCIONISTAS");
		return new FindAccionistaEnCampaniaByDni(dniAccionista, codCampania).execute();
	}

	@Override
	public void addAccionistaEnCampania(String idAccionista, String codCampania, int numAccionesIniciales) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: CAMPANIA_ACCIONISTAS");
		new AddAccionistaEnCampania(idAccionista, codCampania, numAccionesIniciales).execute();
	}

	@Override
	public void actualizarAccionistaEnCampania(AccionistaEnCampaniaDTO dtoAccCamp) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: CAMPANIA_ACCIONISTAS");
		new UpdateAccionistaEnCampania(dtoAccCamp).execute();
	}

	@Override
	public float getPrecioTotal(String codigoCampania) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: CAMPANIA_ACCIONISTAS");
		return new FindPrecioCampania(codigoCampania).execute();
	}

}
