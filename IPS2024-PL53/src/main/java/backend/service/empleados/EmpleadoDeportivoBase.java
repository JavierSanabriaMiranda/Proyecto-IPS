package backend.service.empleados;

import java.util.Date;

public abstract class EmpleadoDeportivoBase extends EmpleadoBase implements EmpleadoDeportivo {

	public EmpleadoDeportivoBase(String nombre, String apellido, String DNI, String telefono, Date fechaNac) {
		super(nombre, apellido, DNI, telefono, fechaNac);
		
	}
	
//	private Equipo equipo;
}
