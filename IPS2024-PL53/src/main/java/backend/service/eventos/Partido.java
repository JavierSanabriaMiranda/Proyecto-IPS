package backend.service.eventos;

import java.util.Date;

import backend.service.horarios.FranjaTiempo;

public class Partido {
	
	private Date fecha;
	private FranjaTiempo horario;
	
	public Partido(Date fecha, FranjaTiempo horario) {
		this.fecha = fecha;
		this.horario = horario;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public FranjaTiempo getHorario() {
		return horario;
	}
}
