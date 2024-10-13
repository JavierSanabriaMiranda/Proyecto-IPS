package backend.service.empleados;

import backend.service.equipos.Equipo;

public interface EmpleadoDeportivo extends Empleado {

	boolean tieneEquipo();

	void setEquipo(Equipo equipo);
}
