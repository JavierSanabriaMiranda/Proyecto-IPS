package backend.service.empleados.deportivos;

import java.util.Date;

import backend.service.empleados.EmpleadoDeportivoBase;

public class Entrenador extends EmpleadoDeportivoBase {

	public Entrenador(String nombre, String apellido, String DNI, String telefono, Date fechaNac, double salario) {
		super(nombre, apellido, DNI, telefono, fechaNac, salario);
		
	}

}
