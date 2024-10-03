package backend.service.empleados;

import java.util.Date;

public abstract class EmpleadoBase {

	private String nombre;
	private String apellido;
	private String DNI;
	private String telefono;
	private Date fechaNac;
	private double salarioAnual;
	
	public EmpleadoBase(String nombre, String apellido, String DNI, String telefono, Date fechaNac) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
	}
}
