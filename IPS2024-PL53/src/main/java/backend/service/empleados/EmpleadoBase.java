package backend.service.empleados;

import java.util.Date;

import shared.gestionempleados.PuestoEmpleado;

public abstract class EmpleadoBase implements Empleado {

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
		if (nombre == null || apellido == null || DNI == null || telefono == null || fechaNac == null)
			throw new IllegalArgumentException("Alguno de los valores del empleado es null");
		
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
	
	@Override
	public abstract PuestoEmpleado getPuesto();
	
	public void setIDEmpleado(String id) {
		this.idEmpleado = id;
	}

	@Override
	public String toString() {
		return String.format("%s | %s %s | %s | %.2f\u20AC", getIDEmpleado(), getNombre(), getApellido(), getDNI(), getSalarioAnual());
	}

	@Override
	public void setNombre(String nombre) {
		if (nombre == null)
			throw new IllegalArgumentException("El nombre no puede ser null");
		if (nombre.isBlank())
			throw new IllegalArgumentException("El nombre no puede ser vacío");
		this.nombre = nombre;
	}

	@Override
	public void setApellido(String apellido) {
		if (apellido == null)
			throw new IllegalArgumentException("El apellido no puede ser null");
		if (apellido.isBlank())
			throw new IllegalArgumentException("El apellido no puede ser vacío");
		this.apellido = apellido;
	}

	@Override
	public void setDNI(String DNI) {
		if (DNI == null)
			throw new IllegalArgumentException("El DNI no puede ser null");
		if (DNI.isBlank())
			throw new IllegalArgumentException("El DNI no puede ser vacío");
		this.DNI = DNI;
	}

	@Override
	public void setTelefono(String telefono) {
		if (telefono == null)
			throw new IllegalArgumentException("El telefono no puede ser null");
		if (telefono.isBlank())
			throw new IllegalArgumentException("El telefono no puede ser vacío");
		this.telefono = telefono;
	}

	@Override
	public void setFechaNac(Date fecha) {
		if (fecha == null)
			throw new IllegalArgumentException("La fecha no puede ser null");
		if (fecha.compareTo(new Date()) > 0) 
			throw new IllegalArgumentException("La fecha no puede ser posterior a la actual");
		this.fechaNac = fecha;
	}

	@Override
	public void setSalarioAnual(double salario) {
		if (salario < 0)
			throw new IllegalArgumentException("El salario no puede ser negativo");
		this.salarioAnual = salario;
	}
	
	
	
	
	
	
}
