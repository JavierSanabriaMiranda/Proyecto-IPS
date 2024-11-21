package backend.data.empleados;

import java.util.List;
import java.util.Optional;

import backend.data.equipos.EntrenadorDto;
import backend.data.equipos.JugadorDto;

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
	Optional<EmpleadoDTO> findEmpleadoNoDeportivoById(String id);
	Optional<EmpleadoDeportivoDTO> findEmpleadoDeportivoById(String id);
	Optional<JugadorDto> findJugadorById(String id);
	Optional<EntrenadorDto> findEntrenadorById(String id);
}
