package backend.service.eventos;

import backend.service.horarios.FranjaTiempo;
import backend.service.instalaciones.ReservaParaInstalacion;
import backend.service.ventas.reservas.Instalacion;

public class Entrenamiento implements ReservaParaInstalacion{

	
	private FranjaTiempo horario;
	private Instalacion instalacion;
	private String idEntrenamiento;
	private String idEquipo;
	
	public Entrenamiento(String idEntrenamiento, FranjaTiempo horario, Instalacion instalacion, String idEquipo) {
		super();
		this.idEntrenamiento = idEntrenamiento;
		this.horario = horario;
		this.instalacion = instalacion;
	}
	
	public FranjaTiempo getHorario() {
		return horario;
	}
	public Instalacion getInstalacion() {
		return instalacion;
	}
	public String getIdEntrenamiento() {
		return idEntrenamiento;
	}
	public String getIdEquipo() {
		return idEquipo;
	}

	@Override
	public int getPrioridad() {
		return 1;
	}
	
	
	
}
