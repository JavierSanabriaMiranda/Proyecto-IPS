package backend.service.empleados.deportivos;

import java.util.Date;

import backend.service.empleados.EmpleadoDeportivoBase;

public class Jugador extends EmpleadoDeportivoBase {

	public Jugador(String nombre, String apellido, String DNI, String telefono, Date fechaNac, double salario) {
		super(nombre, apellido, DNI, telefono, fechaNac, salario);
		
	}
	
}
