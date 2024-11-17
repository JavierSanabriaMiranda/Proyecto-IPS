package backend.service.eventos;

import java.util.Date;

import backend.service.horarios.FranjaTiempo;

public class Partido {
	
	private Date fecha;
	private FranjaTiempo horario;
	private String visitante;
	boolean isEspecial;
	private String idPartido;
	private String idEquipoLocal;
	
	public Partido(Date fecha, FranjaTiempo horario) {
		this.fecha = fecha;
		this.horario = horario;
	}

	
	public Partido(Date fecha, FranjaTiempo horario, String visitante, boolean isEspecial, String idPartido,
			String idEquipoLocal) {
		this.fecha = fecha;
		this.horario = horario;
		this.visitante = visitante;
		this.isEspecial = isEspecial;
		this.idPartido = idPartido;
		this.idEquipoLocal = idEquipoLocal;
	}



	public Date getFecha() {
		return fecha;
	}
	public FranjaTiempo getHorario() {
		return horario;
	}

	public String getIdPartido() {
		return idPartido;
	}

	public String getIdEquipoLocal() {
		return idEquipoLocal;
	}

	public String getVisitante() {
		return visitante;
	}
	
	public boolean isEspecial() {
		return isEspecial;
	}


	@Override
	public String toString() {
		return idEquipoLocal + "\t Vs. \t" + visitante;
	}
	
	
}
