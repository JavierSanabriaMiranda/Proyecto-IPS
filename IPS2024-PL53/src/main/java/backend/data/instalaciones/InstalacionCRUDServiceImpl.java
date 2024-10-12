package backend.data.instalaciones;

import java.util.List;

import backend.data.instalaciones.commands.CargarInstalaciones;

public class InstalacionCRUDServiceImpl implements InstalacionCRUDService {

	@Override
	public List<InstalacionDto> cargarInstalaciones() {
		return new CargarInstalaciones().execute();
	}

}
