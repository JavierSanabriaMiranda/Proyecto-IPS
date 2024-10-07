package backend.data.empleados;

import java.util.List;

public interface EmpleadosCRUDService {

	void addEmpleadoDeportivo(EmpleadoDTO dto);
	void addEmpleadoNoDeportivo(EmpleadoDTO dto);
	void modEmpleado(EmpleadoDTO dto);
	List<EmpleadoDTO> cargarEmpleadosDeportivos();
	List<EmpleadoDTO> cargarEmpleadosNoDeportivos();
}
