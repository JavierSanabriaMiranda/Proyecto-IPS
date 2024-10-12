package shared.gestionhorarios;

import java.util.List;

import backend.service.empleados.EmpleadoNoDeportivo;

public interface GestorHorarios {
	
	List<EmpleadoNoDeportivo> getEmpleadosNoDeportivos();

	/**
	 * Añade un empleado que ya tiene ID a la lista de empleados no deportivos 
	 * @param emp a añadir
	 */
	void addEmpleadoNoDeportivo(EmpleadoNoDeportivo emp);
}
