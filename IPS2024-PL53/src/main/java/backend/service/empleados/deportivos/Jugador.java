package backend.service.empleados.deportivos;

import java.util.Date;

import backend.service.empleados.EmpleadoDeportivoBase;
import shared.gestionempleados.PuestoEmpleado;

public class Jugador extends EmpleadoDeportivoBase {

	public Jugador(String nombre, String apellido, String DNI, String telefono, Date fechaNac, double salario) {
		super(nombre, apellido, DNI, telefono, fechaNac, salario);
		
	}

	@Override
	public PuestoEmpleado getPuesto() {
		return PuestoEmpleado.JUGADOR;
	}

	@Override
	public boolean tieneEquipo() {
		if (getEquipo() != null)
			return true;
		return false;
	}
	
}
