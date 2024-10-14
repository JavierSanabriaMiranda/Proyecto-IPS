package backend.data.partidos;

import java.util.Date;
import java.sql.Time;
import java.util.List;
import backend.data.partidos.commands.FindAllPartidos;
import backend.data.partidos.commands.FindIdByFechaInicioFin;
import backend.data.partidos.commands.FindPartidoByRangoHora;

public class PartidosCRUDImpl implements PartidosCRUDService {

	@Override
	public List<PartidoDTO> findAllPartidos() {
		return new FindAllPartidos().execute();
	}

	@Override
	public String findIdByFechaInicioFin(Date fecha, Time inicio, Time fin) {
		return new FindIdByFechaInicioFin(fecha, inicio, fin).execute();
	}

	@Override
	public List<PartidoDTO> findPartidoByRangoHora(Date fecha, Time inicio, Time fin) {
		return new FindPartidoByRangoHora(fecha, inicio, fin).execute();
	}

}
