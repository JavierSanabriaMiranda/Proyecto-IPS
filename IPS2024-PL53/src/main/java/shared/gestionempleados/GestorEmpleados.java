package shared.gestionempleados;

import backend.service.empleados.EmpleadoDeportivo;
import backend.service.empleados.EmpleadoNoDeportivo;

/**
 * Interfaz que implementará la clase encargada de llevar a cabo la gestión de empleados
 * lo que incluye añadir empleados, borrarlos y modificarlos
 */
public interface GestorEmpleados {
	
	void addEmpleadoDeportivo(EmpleadoDeportivo emp);
	void addEmpleadoNoDeportivo(EmpleadoNoDeportivo emp);
	
	
}
