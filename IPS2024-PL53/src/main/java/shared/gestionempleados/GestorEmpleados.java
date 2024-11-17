package shared.gestionempleados;

import java.util.List;

import backend.service.empleados.Empleado;
import backend.service.empleados.EmpleadoDeportivo;
import backend.service.empleados.EmpleadoNoDeportivo;

/**
 * Interfaz que implementará la clase encargada de llevar a cabo la gestión de empleados
 * lo que incluye añadir empleados, borrarlos y modificarlos
 */
public interface GestorEmpleados {
	
	/**
	 * Añade el empleado nuevo a la lista de empleados deportivos y le asigna
	 * el id 
	 * 
	 * @param emp empleado a añadir
	 */
	void addNuevoEmpleadoDeportivo(EmpleadoDeportivo emp, String id);
	
	/**
	 * Añade el empleado a la lista de empleados NO deportivos y le asigna
	 * el id
	 * @param emp empleado a añadir
	 */
	void addNuevoEmpleadoNoDeportivo(EmpleadoNoDeportivo emp, String id);
	
	/**
	 * Añade un empleado que ya tiene ID a la lista de empleados deportivos 
	 * @param emp a añadir
	 */
	void addEmpleadoDeportivo(EmpleadoDeportivo emp);
	
	/**
	 * Añade un empleado que ya tiene ID a la lista de empleados no deportivos 
	 * @param emp a añadir
	 */
	void addEmpleadoNoDeportivo(EmpleadoNoDeportivo emp);
	
	/**
	 * Devuelve el empleado cuyo id es el recibido como parámetro
	 * @param id del empleado a devolver
	 * @return empleado cuyo id es el recibido como parámetro
	 */
	Empleado getEmpleado(String id);
	
	List<EmpleadoDeportivo> getEmpleadosDeportivos();
	List<EmpleadoNoDeportivo> getEmpleadosNoDeportivos();

	void eliminarEmpleado(String idEmpleado);

	EmpleadoDeportivo getEmpleadoDeportivo(String idEmpleadoNuevo);

	EmpleadoNoDeportivo getEmpleadoNoDeportivo(String idEmpleadoNuevo);

	String generarIDEmpleado();
}
