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
	
	@Override
	public String toString() {
		return "Fecha: " + this.fecha.toString() + ", hora de inicio: " + this.franja.getInicio() 
			+ ", hora de fin: " + this.franja.getFin();
	}

	public Date getFecha() {
		return fecha;
	}

	public FranjaTiempo getFranja() {
		return franja;
	}
	
	
	
}
