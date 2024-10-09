package backend.service.empleados;

import backend.service.empleados.nodeportivos.horarios.Horario;

public interface EmpleadoNoDeportivo extends Empleado {

	Horario getHorario();
}
