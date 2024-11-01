package backend.service.empleados.deportivos;

import java.util.Date;
import java.util.List;

import backend.service.empleados.EmpleadoDeportivoBase;
import backend.service.entrevistas.Entrevista;
import backend.service.entrevistas.FranjaEntrevista;
import shared.gestionempleados.PuestoEmpleado;

public class Jugador extends EmpleadoDeportivoBase {
	
	private List<FranjaEntrevista> franjasEntrevistas;
	private List<Entrevista> entrevistas;

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
