package backend.service.empleados.deportivos;

import java.util.Date;

import backend.service.empleados.EmpleadoDeportivoBase;
import shared.gestionempleados.PuestoEmpleado;

public class Entrenador extends EmpleadoDeportivoBase {
	
	private int posicionEntrenador;

	
	public Entrenador(String nombre, String apellido, String DNI, String telefono, Date fechaNac, double salario) {
		super(nombre, apellido, DNI, telefono, fechaNac, salario);
	}

	@Override
	public PuestoEmpleado getPuesto() {
		return PuestoEmpleado.ENTRENADOR;
	}

	public int getPosicionEntrenador() {
		return posicionEntrenador;
	}

	public void setPosicionEntrenador(int posicionEntrenador) {
		this.posicionEntrenador = posicionEntrenador;
	}

	@Override
	public boolean tieneEquipo() {
		if (getEquipo() != null)
			return true;
		return false;
	}

}
