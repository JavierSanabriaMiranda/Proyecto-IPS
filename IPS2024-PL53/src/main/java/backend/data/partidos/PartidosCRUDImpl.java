package backend.data.partidos;

import java.util.Date;
import java.sql.Time;
import java.util.List;

import backend.data.partidos.commands.AddPartido;
import backend.data.partidos.commands.FindAllPartidos;
import backend.data.partidos.commands.FindIdByFechaInicioFin;
import backend.data.partidos.commands.FindPartidoByIdEquipoRangoHora;

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
	public List<PartidoDTO> findPartidoByIdEquipoRangoHora(String idEquipo, Date fecha, Time inicio, Time fin) {
		return new FindPartidoByIdEquipoRangoHora(idEquipo, fecha, inicio, fin).execute();
	}

	@Override
	public void addPartido(PartidoDTO dto) {
		new AddPartido(dto).execute();
		
	}

}
