package backend.data.acciones;

import java.util.List;

import backend.data.acciones.commands.AddAcciones;

public class AccionesCRUDImpl implements AccionesCRUDService {

	@Override
	public void addAcciones(List<AccionDTO> dtosAcc) {
		new AddAcciones(dtosAcc).execute();
	}

}
