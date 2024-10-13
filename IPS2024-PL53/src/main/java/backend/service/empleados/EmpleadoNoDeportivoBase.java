package backend.service.empleados;

import java.util.Date;

import backend.service.empleados.nodeportivos.horarios.Horario;
import backend.service.empleados.nodeportivos.horarios.HorarioEmpleado;
import shared.gestionempleados.PuestoEmpleado;

public abstract class EmpleadoNoDeportivoBase extends EmpleadoBase implements EmpleadoNoDeportivo {
	
	private Horario horario = new HorarioEmpleado();

	public EmpleadoNoDeportivoBase(String nombre, String apellido, String DNI, String telefono, Date fechaNac, double salario) {
		super(nombre, apellido, DNI, telefono, fechaNac, salario);
	}
	
	public EmpleadoNoDeportivoBase() {
		super();
	}

	@Override
	public abstract PuestoEmpleado getPuesto();

	@Override
	public Horario getHorario() {
		return this.horario;
	}
	
	
}
