package backend.data.partidos;

import java.util.Date;
import java.sql.Time;
import java.util.List;

public interface PartidosCRUDService {

	List<PartidoDTO> findAllPartidos();
	
	String findIdByFechaInicioFin(Date fecha, Time inicio, Time fin);
	
	List<PartidoDTO> findPartidoByIdEquipoRangoHora(String idEquipo, Date fecha, Time inicio, Time fin);

	void addPartido(PartidoDTO dto);
	
	List<PartidoDTO> findPartidosConSuplemento();
}
