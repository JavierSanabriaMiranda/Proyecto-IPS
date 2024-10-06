package shared.gestionempleados.creadores;

import java.util.Date;

import backend.service.empleados.EmpleadoNoDeportivo;

public interface CreadorEmpleadoNoDeportivo {
	
	EmpleadoNoDeportivo getEmpleado(String nombre, String apellido, String DNI, String telefono, 
			Date fechaNac, double salario);

}
