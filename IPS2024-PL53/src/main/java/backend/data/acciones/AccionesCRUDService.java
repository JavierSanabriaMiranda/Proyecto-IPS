package backend.data.acciones;

import java.util.List;

public interface AccionesCRUDService {
	List<AccionDTO> findAccionesByDNI(String DNI);
	void addAcciones(List<AccionDTO> dtosAcc);

}
