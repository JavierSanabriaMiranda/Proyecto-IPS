package backend.service.empleados;

import java.util.Date;

public abstract class EmpleadoBase {

	private String nombre;
	private String apellido;
	private String DNI;
	private String telefono;
	private Date fechaNac;
	private double salarioAnual;
	
	/**
	 * Constructor para crear objetos EmpleadoBase sin instanciar atributos. Su función es poder utilizar 
	 * los métodos de la clase sin tratar con un objeto con datos de la BBDD
	 */
	public EmpleadoBase() {
		
	}
	
	/**
	 * Constructor para crear objetos EmpleadoBase instanciando sus atributos
	 * @param nombre
	 * @param apellido
	 * @param DNI
	 * @param telefono
	 * @param fechaNac
	 */
	public EmpleadoBase(String nombre, String apellido, String DNI, String telefono, Date fechaNac) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDNI() {
		return DNI;
	}

	public String getTelefono() {
		return telefono;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public double getSalarioAnual() {
		return salarioAnual;
	}
	
	
}
