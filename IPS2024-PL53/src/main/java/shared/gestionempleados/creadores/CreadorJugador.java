package shared.gestionempleados.creadores;

import java.util.Date;

import backend.service.empleados.EmpleadoDeportivo;
import backend.service.empleados.deportivos.Jugador;

public class CreadorJugador implements CreadorEmpleadoDeportivo {

	@Override
	public EmpleadoDeportivo getEmpleado(String nombre, String apellido, String DNI, String telefono, Date fechaNac,
			double salario) {
		return new Jugador(nombre, apellido, DNI, telefono, fechaNac);
	}

}
