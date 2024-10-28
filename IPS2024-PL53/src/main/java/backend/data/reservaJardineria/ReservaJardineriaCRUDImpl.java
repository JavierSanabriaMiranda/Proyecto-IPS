package backend.data.reservaJardineria;

import backend.data.reservaJardineria.commands.AddReservaJardineria;

public class ReservaJardineriaCRUDImpl implements ReservaJardineriaCRUDService{

	@Override
	public void addReservaJardineria(ReservaJardineriaDTO dto) {
		 new AddReservaJardineria(dto).execute();
	}

}
