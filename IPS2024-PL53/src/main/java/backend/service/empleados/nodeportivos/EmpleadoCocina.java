package backend.service.empleados.nodeportivos;

import java.util.Date;

import backend.service.empleados.EmpleadoNoDeportivoBase;

public class EmpleadoCocina extends EmpleadoNoDeportivoBase {

	public EmpleadoCocina(String nombre, String apellido, String DNI, String telefono, Date fechaNac, double salario) {
		super(nombre, apellido, DNI, telefono, fechaNac, salario);
		
	}

}
