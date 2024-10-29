package backend.data.reservaJardineria;

import java.util.List;

public interface ReservaJardineriaCRUDService {

	void addReservaJardineria(ReservaJardineriaDTO res);
	
	List<ReservaJardineriaDTO> cargarReservasJardineria();
}
