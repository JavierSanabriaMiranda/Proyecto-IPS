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
	 * un id propio
	 * 
	 * @param emp empleado a añadir
	 * @return id generado para el nuevo empleado
	 */
	String addNuevoEmpleadoDeportivo(EmpleadoDeportivo emp);
	
	/**
	 * Añade el empleado a la lista de empleados NO deportivos y le asigna
	 * un id propio
	 * @param emp empleado a añadir
	 * @return id generado para el nuevo empleado
	 */
	String addNuevoEmpleadoNoDeportivo(EmpleadoNoDeportivo emp);
	
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
}
