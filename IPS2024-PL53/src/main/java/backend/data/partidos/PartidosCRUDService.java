package backend.data.partidos;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface PartidosCRUDService {

	List<PartidoDTO> findAllPartidos();
	
	String findIdByFechaInicioFin(String fecha, String inicio, String fin);
}
