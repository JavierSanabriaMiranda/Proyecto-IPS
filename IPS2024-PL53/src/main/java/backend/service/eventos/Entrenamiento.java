package backend.service.eventos;

import java.util.Date;

import backend.service.horarios.FranjaTiempo;
import backend.service.ventas.reservas.Instalacion;

public class Entrenamiento {

	private Date fecha;
	private FranjaTiempo horario;
	private Instalacion instalacion;
	
	public Entrenamiento(Date fecha, FranjaTiempo horario, Instalacion instalacion) {
		super();
		this.fecha = fecha;
		this.horario = horario;
		this.instalacion = instalacion;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public FranjaTiempo getHorario() {
		return horario;
	}
	public Instalacion getInstalacion() {
		return instalacion;
	}
	
	
	
}
