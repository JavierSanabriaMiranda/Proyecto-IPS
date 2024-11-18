package backend.data.instalaciones;

import java.util.List;

import backend.data.instalaciones.commands.CargarInstalaciones;
import backend.util.log.LogManager;

public class InstalacionCRUDServiceImpl implements InstalacionCRUDService {

	@Override
	public List<InstalacionDto> cargarInstalaciones() {
		LogManager.logAction("Acceso a Base de Datos. Tabla: INSTALACION");
		return new CargarInstalaciones().execute();
	}

}
