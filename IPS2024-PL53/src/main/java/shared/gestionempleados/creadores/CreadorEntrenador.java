package shared.gestionempleados.creadores;

import java.util.Date;

import backend.service.empleados.EmpleadoDeportivo;
import backend.service.empleados.deportivos.Entrenador;

public class CreadorEntrenador implements CreadorEmpleadoDeportivo {

	@Override
	public EmpleadoDeportivo getEmpleado(String nombre, String apellido, String DNI, String telefono, Date fechaNac,
			double salario) {
		return new Entrenador(nombre, apellido, DNI, telefono, fechaNac);
	}

}
