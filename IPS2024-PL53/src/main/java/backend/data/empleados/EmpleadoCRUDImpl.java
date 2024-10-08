package backend.data.empleados;

import backend.data.empleados.commands.AddEmpleadoDeportivo;
import backend.data.empleados.commands.AddEmpleadoNoDeportivo;

public class EmpleadoCRUDImpl implements EmpleadosCRUDService {

	@Override
	public void addEmpleadoDeportivo(EmpleadoDTO dto) {
		new AddEmpleadoDeportivo(dto).execute();
	}

	@Override
	public void addEmpleadoNoDeportivo(EmpleadoDTO dto) {
		new AddEmpleadoNoDeportivo(dto).execute();
	}

}
