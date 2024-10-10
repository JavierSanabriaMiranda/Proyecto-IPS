package backend.service.empleados.nodeportivos.horarios;

import java.time.Duration;
import java.time.LocalTime;

public class TurnoBase implements Turno {

	private String idTurno;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	
	public TurnoBase(String idTurno, LocalTime inicio, LocalTime fin) {
		if (idTurno == null || inicio == null || fin == null)
			throw new IllegalArgumentException("No se puede introducir una hora nula");
		if (inicio.compareTo(fin) < 0)
			throw new IllegalArgumentException("La hora de finalización no puede ser menor que la hora de inicio");
		this.idTurno = idTurno;
		this.horaInicio = inicio;
		this.horaFin = fin;
	}
	
	public LocalTime getHoraInicio() {
		return this.horaInicio;
	}
	
	public LocalTime getHoraFin() {
		return this.horaFin;
	}
	
	public String getIDTurno() {
		return this.idTurno;
	}
	
	public void setIDTurno(String id) {
		this.idTurno = id;
	}

	@Override
	public long getHorasDuracion() {
		return Duration.between(horaInicio, horaFin).toHours();
	}
	
}
