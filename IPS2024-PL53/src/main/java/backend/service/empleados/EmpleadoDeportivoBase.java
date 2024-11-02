package backend.service.empleados;

import java.util.Date;

import backend.service.equipos.Equipo;
import shared.gestionempleados.PuestoEmpleado;

public abstract class EmpleadoDeportivoBase extends EmpleadoBase implements EmpleadoDeportivo {
	
	private Equipo equipo;

	public EmpleadoDeportivoBase(String nombre, String apellido, String DNI, String telefono, Date fechaNac, double salario) {
		super(nombre, apellido, DNI, telefono, fechaNac, salario);
		
	}
	
	@Override
	public abstract PuestoEmpleado getPuesto();

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	public void addJugadorAEquipo(EmpleadoDeportivo emp) {
		this.equipo.addJugadoresAEquipo(emp);
	}
	
	
}
