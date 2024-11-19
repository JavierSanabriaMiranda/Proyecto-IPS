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
import backend.data.empleados.commands.FindEmpleadoNoDeportivoById;
import backend.data.empleados.commands.FindIdEquipoByJugadorId;
import backend.data.empleados.commands.FindJugadoresProfesionales;
import backend.data.empleados.commands.ModEmpleado;
import backend.data.empleados.commands.UpdateEquipoDeEmpleadoDeportivo;

public class EmpleadoCRUDImpl implements EmpleadosCRUDService {

	@Override
	public void addEmpleadoDeportivo(EmpleadoDTO dto) {
		new AddEmpleadoDeportivo(dto).execute();
	}

	@Override
	public void addEmpleadoNoDeportivo(EmpleadoDTO dto) {
		new AddEmpleadoNoDeportivo(dto).execute();
	}

	@Override
	public void modEmpleado(EmpleadoDTO dto) {
		new ModEmpleado(dto).execute();
	}

	@Override
	public List<EmpleadoDeportivoDTO> cargarEmpleadosDeportivos() {
		return new CargarEmpleadosDeportivos().execute();
	}

	@Override
	public List<EmpleadoDTO> cargarEmpleadosNoDeportivos() {
		return new CargarEmpleadosNoDeportivos().execute();
	}

	@Override
	public void eliminarEmpleado(EmpleadoDTO dto) {
		new EliminarEmpleado(dto).execute();
	}
	
	public String findIdEquipoByJugadorId(String idJugador) {
		return new FindIdEquipoByJugadorId(idJugador).execute();
	}
	
	public List<EmpleadoDTO> findJugadoresProfesionales() {
		return new FindJugadoresProfesionales().execute();
	}

	@Override
	public void updateEmpleadoDeportivo(EmpleadoDeportivoDTO dto) {
		new UpdateEquipoDeEmpleadoDeportivo(dto).execute();
	}

	@Override
	public Optional<EmpleadoDeportivoDTO> findEmpleadoDeportivoByDNI(String dni) {
		return new FindEmpleadoDeportivoByDNI(dni).execute();
	}

	@Override
	public Optional<EmpleadoDTO> findEmpleadoNoDeportivoByDNI(String dni) {
		return new FindEmpleadoNoDeportivoByDNI(dni).execute();
	}

	@Override
	public Optional<EmpleadoDTO> findEmpleadoNoDeportivoById(String id) {
		return new FindEmpleadoNoDeportivoById(id).execute();
	}

}
