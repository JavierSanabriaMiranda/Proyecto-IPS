package backend.data.empleados;

import java.util.List;
import java.util.Optional;

public interface EmpleadosCRUDService {

	void addEmpleadoDeportivo(EmpleadoDTO dto);
	void addEmpleadoNoDeportivo(EmpleadoDTO dto);
	void modEmpleado(EmpleadoDTO dto);
	List<EmpleadoDeportivoDTO> cargarEmpleadosDeportivos();
	List<EmpleadoDTO> cargarEmpleadosNoDeportivos();
	void eliminarEmpleado(EmpleadoDTO dto);
	void updateEmpleadoDeportivo(EmpleadoDeportivoDTO dto);
	String findIdEquipoByJugadorId(String idJugador);
	List<EmpleadoDTO> findJugadoresProfesionales();
	Optional<EmpleadoDeportivoDTO> findEmpleadoDeportivoByDNI(String dni);
	Optional<EmpleadoDTO> findEmpleadoNoDeportivoByDNI(String dni);
}
