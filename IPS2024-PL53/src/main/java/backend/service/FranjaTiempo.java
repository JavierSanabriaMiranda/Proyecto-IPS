package backend.service;

import java.sql.Time;

public class FranjaTiempo {

	private Time inicio;
	private Time fin;
	
	public FranjaTiempo(Time inicio, Time fin) {
		this.inicio = inicio;
		this.fin = fin;
	}
}
