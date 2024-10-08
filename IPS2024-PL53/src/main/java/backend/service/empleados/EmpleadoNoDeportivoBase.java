package backend.service.empleados;

import java.util.Date;

import shared.gestionempleados.PuestoEmpleado;

public abstract class EmpleadoNoDeportivoBase extends EmpleadoBase implements EmpleadoNoDeportivo {

	public EmpleadoNoDeportivoBase(String nombre, String apellido, String DNI, String telefono, Date fechaNac, double salario) {
		super(nombre, apellido, DNI, telefono, fechaNac, salario);
	}
	
	public EmpleadoNoDeportivoBase() {
		super();
	}

	@Override
	public abstract PuestoEmpleado getPuesto();
}
