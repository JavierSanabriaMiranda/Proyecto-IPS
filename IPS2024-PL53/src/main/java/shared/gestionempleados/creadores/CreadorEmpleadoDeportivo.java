package shared.gestionempleados.creadores;

import java.util.Date;

import backend.service.empleados.EmpleadoDeportivo;

public interface CreadorEmpleadoDeportivo {

	EmpleadoDeportivo getEmpleado(String nombre, String apellido, String DNI, String telefono, 
			Date fechaNac, double salario);
}
