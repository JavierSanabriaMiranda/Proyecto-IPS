package backend.service.empleados.nodeportivos.horarios;

import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoPuntual extends TurnoBase {

	private LocalDate dia;
	
	public TurnoPuntual(String idTurno, LocalTime inicio, LocalTime fin, LocalDate dia) {
		super(idTurno, inicio, fin);
		this.dia = dia;
	}
	
	public LocalDate getDia() {
		return dia;	
	}

}
