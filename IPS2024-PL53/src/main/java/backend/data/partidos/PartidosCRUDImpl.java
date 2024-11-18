package backend.data.partidos;

import java.util.Date;
import java.sql.Time;
import java.util.List;

import backend.data.partidos.commands.AddPartido;
import backend.data.partidos.commands.FindAllPartidos;
import backend.data.partidos.commands.FindIdByFechaInicioFin;
import backend.data.partidos.commands.FindPartidoByIdEquipoRangoHora;
import backend.data.partidos.commands.FindPartidosConSuplemento;
import backend.util.log.LogManager;

public class PartidosCRUDImpl implements PartidosCRUDService {

	@Override
	public List<PartidoDTO> findAllPartidos() {
		LogManager.logAction("Acceso a Base de Datos. Tabla: PARTIDO");
		return new FindAllPartidos().execute();
	}

	@Override
	public String findIdByFechaInicioFin(Date fecha, Time inicio, Time fin) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: PARTIDO");
		return new FindIdByFechaInicioFin(fecha, inicio, fin).execute();
	}

	@Override
	public List<PartidoDTO> findPartidoByIdEquipoRangoHora(String idEquipo, Date fecha, Time inicio, Time fin) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: PARTIDO");
		return new FindPartidoByIdEquipoRangoHora(idEquipo, fecha, inicio, fin).execute();
	}

	@Override
	public void addPartido(PartidoDTO dto) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: PARTIDO");
		new AddPartido(dto).execute();
		
	}

	@Override
	public List<PartidoDTO> findPartidosConSuplemento() {
		LogManager.logAction("Acceso a Base de Datos. Tabla: PARTIDO");
		return new FindPartidosConSuplemento().execute();
	}

}
