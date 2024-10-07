package backend.service.empleados;

import java.util.Date;

public abstract class EmpleadoBase {

	private String idEmpleado;
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
	public EmpleadoBase(String nombre, String apellido, String DNI, String telefono, Date fechaNac, double salario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
		this.salarioAnual = salario;
	}
	
	public String getIDEmpleado() {
		return idEmpleado;
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
	
	public void setIDEmpleado(String id) {
		this.idEmpleado = id;
	}

	@Override
	public String toString() {
		return String.format("%s | %s %s | %s | %.2f\u20AC", getIDEmpleado(), getNombre(), getApellido(), getDNI(), getSalarioAnual());
	}
	
	
	
	
	
	
}
