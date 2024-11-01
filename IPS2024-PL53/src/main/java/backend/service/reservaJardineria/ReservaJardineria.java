package backend.service.reservaJardineria;

import backend.service.horarios.FranjaTiempo;
import backend.service.instalaciones.ReservaParaInstalacion;
import backend.service.empleados.nodeportivos.EmpleadoJardineria;
import backend.service.ventas.reservas.Instalacion;

public class ReservaJardineria implements ReservaParaInstalacion{
	
	private FranjaTiempo horario;
	private Instalacion instalacion;
	private EmpleadoJardineria jardinero;
	private String codReservaJardineria;

	public ReservaJardineria(FranjaTiempo horario, Instalacion instalacion, EmpleadoJardineria jardinero,
			String codReservaJardineria) {
		this.horario = horario;
		this.instalacion = instalacion;
		this.jardinero = jardinero;
		this.codReservaJardineria = codReservaJardineria;
		if (jardinero != null)
			addReservaAEmpleado();
		
	}
	
	public void addReservaAEmpleado() {
		this.jardinero.addTurno(this);
	}
	
	public FranjaTiempo getHorario() {
		return horario;
	}
	public Instalacion getInstalacion() {
		return instalacion;
	}
	public EmpleadoJardineria getJardinero() {
		return jardinero;
	}
	public String getCodReservaJardineria() {
		return codReservaJardineria;
	}


	@Override
	public int getPrioridad() {
		return 2;
	}
	
	

}
