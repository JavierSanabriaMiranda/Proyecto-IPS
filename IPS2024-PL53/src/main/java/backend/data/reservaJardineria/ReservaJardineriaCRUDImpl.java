package backend.data.reservaJardineria;

import java.util.List;

import backend.data.reservaJardineria.commands.AddReservaJardineria;
import backend.data.reservaJardineria.commands.CargarReservasJardineria;
import backend.data.reservaJardineria.commands.DeleteReservaJardineria;
import backend.util.log.LogManager;

public class ReservaJardineriaCRUDImpl implements ReservaJardineriaCRUDService{

	@Override
	public void addReservaJardineria(ReservaJardineriaDTO dto) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: RESERVA_JARDINERIA");
		 new AddReservaJardineria(dto).execute();
	}

	@Override
	public List<ReservaJardineriaDTO> cargarReservasJardineria() {
		LogManager.logAction("Acceso a Base de Datos. Tabla: RESERVA_JARDINERIA");
		return new CargarReservasJardineria().execute();
	}

	@Override
	public void deleteReservaJardineria(String codReserva) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: RESERVA_JARDINERIA");
		new DeleteReservaJardineria(codReserva).execute();
	}

}
