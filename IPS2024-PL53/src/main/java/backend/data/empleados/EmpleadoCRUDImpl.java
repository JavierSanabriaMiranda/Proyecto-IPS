package backend.data.empleados;

import java.util.List;
import java.util.Optional;

import backend.data.empleados.commands.AddEmpleadoDeportivo;
import backend.data.empleados.commands.AddEmpleadoNoDeportivo;
import backend.data.empleados.commands.CargarEmpleadosDeportivos;
import backend.data.empleados.commands.CargarEmpleadosNoDeportivos;
import backend.data.empleados.commands.EliminarEmpleado;
import backend.data.empleados.commands.FindEmpleadoDeportivoByDNI;
import backend.data.empleados.commands.FindEmpleadoNoDeportivoByDNI;
import backend.data.empleados.commands.FindIdEquipoByJugadorId;
import backend.data.empleados.commands.FindJugadoresProfesionales;
import backend.data.empleados.commands.ModEmpleado;
import backend.data.empleados.commands.UpdateEquipoDeEmpleadoDeportivo;
import backend.util.log.LogManager;

public class EmpleadoCRUDImpl implements EmpleadosCRUDService {

	@Override
	public void addEmpleadoDeportivo(EmpleadoDTO dto) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: EMPLEADO_DEPORTIVO, JUGADOR, ENTRENADOR");
		new AddEmpleadoDeportivo(dto).execute();
	}

	@Override
	public void addEmpleadoNoDeportivo(EmpleadoDTO dto) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: EMPLEADO_NO_DEPORTIVO");
		new AddEmpleadoNoDeportivo(dto).execute();
	}

	@Override
	public void modEmpleado(EmpleadoDTO dto) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: EMPLEADO_NO_DEPORTIVO, EMPLEADO_DEPORTIVO");
		new ModEmpleado(dto).execute();
	}

	@Override
	public List<EmpleadoDeportivoDTO> cargarEmpleadosDeportivos() {
		LogManager.logAction("Acceso a Base de Datos. Tabla: EMPLEADO_DEPORTIVO, JUGADOR, ENTRENADOR");
		return new CargarEmpleadosDeportivos().execute();
	}

	@Override
	public List<EmpleadoDTO> cargarEmpleadosNoDeportivos() {
		LogManager.logAction("Acceso a Base de Datos. Tabla: EMPLEADO_NO_DEPORTIVO");
		return new CargarEmpleadosNoDeportivos().execute();
	}

	@Override
	public void eliminarEmpleado(EmpleadoDTO dto) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: EMPLEADO_NO_DEPORTIVO, EMPLEADO_DEPORTIVO, JUGADOR, ENTRENADOR");
		new EliminarEmpleado(dto).execute();
	}
	
	public String findIdEquipoByJugadorId(String idJugador) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: JUGADOR");
		return new FindIdEquipoByJugadorId(idJugador).execute();
	}
	
	public List<EmpleadoDTO> findJugadoresProfesionales() {
		LogManager.logAction("Acceso a Base de Datos. Tabla: EMPLEADO_DEPORTIVO, JUGADOR, EQUIPO_PROFESIONAL");
		return new FindJugadoresProfesionales().execute();
	}

	@Override
	public void updateEmpleadoDeportivo(EmpleadoDeportivoDTO dto) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: JUGADOR, ENTRENADOR");
		new UpdateEquipoDeEmpleadoDeportivo(dto).execute();
	}

	@Override
	public Optional<EmpleadoDeportivoDTO> findEmpleadoDeportivoByDNI(String dni) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: EMPLEADO_DEPORTIVO");
		return new FindEmpleadoDeportivoByDNI(dni).execute();
	}

	@Override
	public Optional<EmpleadoDTO> findEmpleadoNoDeportivoByDNI(String dni) {
		LogManager.logAction("Acceso a Base de Datos. Tabla: EMPLEADO_NO_DEPORTIVO");
		return new FindEmpleadoNoDeportivoByDNI(dni).execute();
	}

}
