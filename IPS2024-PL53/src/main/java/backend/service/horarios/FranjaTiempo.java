package backend.service.horarios;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class FranjaTiempo {
	
	private TipoEvento evento; //atributo creado para poder identificar en la interfaz a que corresponde la franja horaria seleccionada
	//Si es un entrenamiento debe ser: "Entrenamiento Equipo" y si es una reserva: "Reserva"
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private Date fecha;
	
	public FranjaTiempo(TipoEvento evento, LocalTime hInicio, LocalTime hFin, Date fecha) {
		this.evento = evento;
		this.fecha = fecha;
		this.horaFin = hFin;
		this.horaInicio = hInicio;
	}
	
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public LocalTime getHoraFin() {
		return horaFin;
	}
	public Date getFecha() {
		return fecha;
	}

	public TipoEvento getEvento() {
		return evento;
	}
	
	public long getDuracion() {
        return horaInicio.until(horaFin, ChronoUnit.MINUTES);
    }
	
	
	
	

}
