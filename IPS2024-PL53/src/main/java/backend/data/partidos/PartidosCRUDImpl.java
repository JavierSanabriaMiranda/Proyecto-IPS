package backend.data.partidos;

import java.util.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import backend.data.partidos.commands.FindAllPartidos;
import backend.data.partidos.commands.FindIdByFechaInicioFin;

public class PartidosCRUDImpl implements PartidosCRUDService {

	@Override
	public List<PartidoDTO> findAllPartidos() {
		List<PartidoDTO> res = null;
		try {
			res = new FindAllPartidos().execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public String findIdByFechaInicioFin(Date fecha, Time inicio, Time fin) {
		return new FindIdByFechaInicioFin(fecha, inicio, fin).execute();
	}

}
