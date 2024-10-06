package backend.service.empleados.nodeportivos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import backend.service.empleados.EmpleadoDeportivo;
import backend.service.empleados.EmpleadoNoDeportivo;
import backend.service.empleados.EmpleadoNoDeportivoBase;
import shared.gestionempleados.GestorEmpleados;

public class Gerente extends EmpleadoNoDeportivoBase implements GestorEmpleados {

	private List<EmpleadoDeportivo> empDeportivos;
	private List<EmpleadoNoDeportivo> empNoDeportivos;
	
	
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
		empDeportivos = new ArrayList<>();
		empNoDeportivos = new ArrayList<>();
	}

	public Gerente() {
		super();
		empDeportivos = new ArrayList<>();
		empNoDeportivos = new ArrayList<>();
	}

	@Override
	public void addEmpleadoDeportivo(EmpleadoDeportivo emp) {
		if (emp == null)
			throw new IllegalArgumentException("No se puede introducir un empleado null en la lista");
		empDeportivos.add(emp);
	}

	@Override
	public void addEmpleadoNoDeportivo(EmpleadoNoDeportivo emp) {
		if (emp == null)
			throw new IllegalArgumentException("No se puede introducir un empleado null en la lista");
		empNoDeportivos.add(emp);
	}
	
	

	
}
