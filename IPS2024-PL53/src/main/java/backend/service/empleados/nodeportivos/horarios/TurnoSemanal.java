package backend.service.empleados.nodeportivos.horarios;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class TurnoSemanal extends TurnoBase {

	private DayOfWeek diaSemana;
	
	public TurnoSemanal(String idTurno, LocalTime inicio, LocalTime fin, DayOfWeek dia) {
		super(idTurno, inicio, fin);
		this.diaSemana = dia;
	}
	
	public DayOfWeek getDiaSemana() {
		return diaSemana;
	}
	
}
