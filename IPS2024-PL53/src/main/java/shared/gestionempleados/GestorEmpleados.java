package shared.gestionempleados;

import backend.service.empleados.Empleado;
import backend.service.empleados.EmpleadoDeportivo;
import backend.service.empleados.EmpleadoNoDeportivo;

/**
 * Interfaz que implementará la clase encargada de llevar a cabo la gestión de empleados
 * lo que incluye añadir empleados, borrarlos y modificarlos
 */
public interface GestorEmpleados {
	
	/**
	 * Añade el empleado a la lista de empleados deportivos
	 * @param emp empleado a añadir
	 * @return id generado para el nuevo empleado
	 */
	String addEmpleadoDeportivo(EmpleadoDeportivo emp);
	
	/**
	 * Añade el empleado a la lista de empleados NO deportivos
	 * @param emp empleado a añadir
	 * @return id generado para el nuevo empleado
	 */
	String addEmpleadoNoDeportivo(EmpleadoNoDeportivo emp);
	
	/**
	 * Devuelve el empleado cuyo id es el recibido como parámetro
	 * @param id del empleado a devolver
	 * @return empleado cuyo id es el recibido como parámetro
	 */
	Empleado getEmpleado(String id);
}
