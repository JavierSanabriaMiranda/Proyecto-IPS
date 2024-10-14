package backend.service.entrevistas;

import java.util.Date;

import backend.service.FranjaTiempo;

public class FranjaEntrevista {

	private Date fecha;
	private FranjaTiempo franja;
	
	public FranjaEntrevista(Date fecha, FranjaTiempo franja) {
		this.fecha = fecha;
		this.franja = franja;
	}
}
