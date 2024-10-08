package backend.service.empleados;

import java.util.Date;

public class EmpleadoNoDeportivoBase extends EmpleadoBase implements EmpleadoNoDeportivo {

	public EmpleadoNoDeportivoBase(String nombre, String apellido, String DNI, String telefono, Date fechaNac) {
		super(nombre, apellido, DNI, telefono, fechaNac);
	}
	
	public EmpleadoNoDeportivoBase() {
		super();
	}

	
}
