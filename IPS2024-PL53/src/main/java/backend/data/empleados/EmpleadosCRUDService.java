package backend.data.empleados;

import java.util.List;

public interface EmpleadosCRUDService {

	void addEmpleadoDeportivo(EmpleadoDTO dto);
	void addEmpleadoNoDeportivo(EmpleadoDTO dto);
	void modEmpleado(EmpleadoDTO dto);
	List<EmpleadoDeportivoDTO> cargarEmpleadosDeportivos();
	List<EmpleadoDTO> cargarEmpleadosNoDeportivos();
	void eliminarEmpleado(EmpleadoDTO dto);
	void updateEmpleadoDeportivo(EmpleadoDeportivoDTO dto);
}
