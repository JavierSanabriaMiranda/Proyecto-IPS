package backend.service.empleados.nodeportivos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import backend.service.empleados.EmpleadoNoDeportivoBase;
import backend.service.reservaJardineria.ReservaJardineria;
import shared.gestionempleados.PuestoEmpleado;

public class EmpleadoJardineria extends EmpleadoNoDeportivoBase {

	private List<ReservaJardineria> turnosJardineria = new ArrayList<>();
	
	
	public EmpleadoJardineria(String nombre, String apellido, String DNI, String telefono, Date fechaNac, double salario) {
		super(nombre, apellido, DNI, telefono, fechaNac, salario);
		
	}
	
	public void addTurno(ReservaJardineria turno) {
		turnosJardineria.add(turno);
	}
	
	public List<ReservaJardineria> getTurnosReservas(){
		return turnosJardineria;
	}
	

	@Override
	public PuestoEmpleado getPuesto() {
		return PuestoEmpleado.EMPLEADO_JARDINERIA;
	}

}
