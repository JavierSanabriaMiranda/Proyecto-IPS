package backend.data.reservaJardineria;

import java.util.List;

import backend.data.reservaJardineria.commands.AddReservaJardineria;
import backend.data.reservaJardineria.commands.CargarReservasJardineria;
import backend.data.reservaJardineria.commands.DeleteReservaJardineria;

public class ReservaJardineriaCRUDImpl implements ReservaJardineriaCRUDService{

	@Override
	public void addReservaJardineria(ReservaJardineriaDTO dto) {
		 new AddReservaJardineria(dto).execute();
	}

	@Override
	public List<ReservaJardineriaDTO> cargarReservasJardineria() {
		return new CargarReservasJardineria().execute();
	}

	@Override
	public void deleteReservaJardineria(String codReserva) {
		new DeleteReservaJardineria(codReserva).execute();
		
	}

}
