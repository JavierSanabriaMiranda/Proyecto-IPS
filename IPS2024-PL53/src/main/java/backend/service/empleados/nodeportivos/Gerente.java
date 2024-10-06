package backend.service.empleados.nodeportivos;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import backend.service.empleados.EmpleadoDeportivo;
import backend.service.empleados.EmpleadoNoDeportivo;
import backend.service.empleados.EmpleadoNoDeportivoBase;
import backend.service.empleados.GeneradorIDEmpleado;
import shared.gestionempleados.GestorEmpleados;

public class Gerente extends EmpleadoNoDeportivoBase implements GestorEmpleados {

	/**
	 * Diccionario de empleados no deportivos cuya clave es el ID del empleado
	 */
	private Map<String, EmpleadoDeportivo> empDeportivos;
	/**
	 * Diccionario de NO empleados no deportivos cuya clave es el ID del empleado
	 */
	private Map<String, EmpleadoNoDeportivo> empNoDeportivos;
	/**
	 * Generador aleatorio de IDs para la creación de nuevos empleados
	 */
	private GeneradorIDEmpleado generadorID = new GeneradorIDEmpleado();
	
	/**
	 * Constructor que sirve para instanciar gerentes utilizados como almacenamiento de datos
	 * @param nombre
	 * @param apellido
	 * @param DNI
	 * @param telefono
	 * @param fechaNac
	 */
	public Gerente(String nombre, String apellido, String DNI, String telefono, Date fechaNac) {
		super(nombre, apellido, DNI, telefono, fechaNac);
		empDeportivos = new HashMap<>();
		empNoDeportivos = new HashMap<>();
	}

	public Gerente() {
		super();
		empDeportivos = new HashMap<>();
		empNoDeportivos = new HashMap<>();
	}

	@Override
	public void addEmpleadoDeportivo(EmpleadoDeportivo emp) {
		if (emp == null)
			throw new IllegalArgumentException("No se puede introducir un empleado null en la lista");
		emp.setIDEmpleado(generarIDEmpleado());
		empDeportivos.put(emp.getIDEmpleado(), emp);
	}

	@Override
	public void addEmpleadoNoDeportivo(EmpleadoNoDeportivo emp) {
		if (emp == null)
			throw new IllegalArgumentException("No se puede introducir un empleado null en la lista");
		emp.setIDEmpleado(generarIDEmpleado());
		empNoDeportivos.put(emp.getIDEmpleado(), emp);
	}
	
	/**
	 * Genera un ID de empleado único de la forma EXXXXXXX donde las X son números aleatorios
	 * @return
	 */
	private String generarIDEmpleado() {
		int numeroID;
		do {
			numeroID = generadorID.getNuevoID();
		} while(empDeportivos.containsKey("E" + numeroID) || empNoDeportivos.containsKey("E" + numeroID));
		
		return "E" + numeroID;
	}
	
	

	
}
