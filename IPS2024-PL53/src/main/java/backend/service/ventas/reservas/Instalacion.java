package backend.service.ventas.reservas;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import backend.service.eventos.Entrenamiento;
import backend.service.horarios.FranjaTiempo;
import backend.service.horarios.TipoEvento;

public class Instalacion {
	private String nombreInstalacion;
	private List<Reserva> reservas = new ArrayList<Reserva>();
	private List<Entrenamiento> entrenamientos = new ArrayList<Entrenamiento>();
	
	public Instalacion(String nombreInstalacion) {
		this.nombreInstalacion = nombreInstalacion;
		
	}
	
	

	public List<Reserva> getReservas() {
		return reservas;
	}
	public List<Entrenamiento> getEntrenamientos() {
		return entrenamientos;
	}
	public String getNombreInstalacion() {
		return nombreInstalacion;
	}

	public List<FranjaTiempo> getEventos(Date dia) {
		List<FranjaTiempo> lista = new ArrayList<FranjaTiempo>();
		for (Reserva reserva : reservas) {
			if (reserva.getHorario().getFecha().equals(dia)) { //El cdate de la reserva esta a null
				lista.add(reserva.getHorario());
			}
		}
		for (Entrenamiento entrenamiento : entrenamientos) {
			if (entrenamiento.getHorario().getFecha().equals(dia)) {
				lista.add(entrenamiento.getHorario());
			}
		}
		return lista;
	}
	
	public void addReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	

	public void addEntrenamiento(Entrenamiento entrenamiento) {
		this.entrenamientos.add(entrenamiento);
	}


	public boolean esFranjaPosible(FranjaTiempo fj) {
	    // Duración mínima de la reserva: 60 minutos (1 hora)
	    if (fj.getDuracion() < 60) {
	        return false;
	    }

	    // Obtener eventos existentes en la fecha de la franja de tiempo propuesta
	    Date fecha = fj.getFecha(); 
	    List<FranjaTiempo> eventosDelDia = getEventos(fecha);

	    for (FranjaTiempo evento : eventosDelDia) {
	        // Si la nueva franja se solapa con un evento existente
	        if (solapa(fj, evento)) {
	            return false;
	        }

	        // Verificar que la reserva no sea antes de 1h30 después de un evento, pero solo si es un entrenamiento
	        if (evento.getEvento() == TipoEvento.ENTRENAMIENTO && !puedeReservarDespuesDe(evento, fj)) {
	            return false;
	        }
	    }

	    // Si no hubo solapamientos ni conflictos con la restricción de 1h30, es posible
	    return true;
	}

	// Verifica si dos franjas de tiempo se solapan
	private boolean solapa(FranjaTiempo nueva, FranjaTiempo existente) {
	    return nueva.getHoraInicio().isBefore(existente.getHoraFin()) && nueva.getHoraFin().isAfter(existente.getHoraInicio())
	    		 && !(nueva.getHoraFin().equals(existente.getHoraInicio()));
	}

	// Verifica si una reserva nueva puede realizarse después de 1h30 de un evento existente
	private boolean puedeReservarDespuesDe(FranjaTiempo evento, FranjaTiempo nuevaReserva) {
	    Calendar cal = Calendar.getInstance();
	    
	    // Añadimos 1h30 a la hora de fin del evento
	    cal.setTime(convertirALegacyDate(evento.getHoraFin()));  // Convertir LocalTime a Date
	    cal.add(Calendar.MINUTE, 90);  // Añadir 90 minutos
	    
	    Date horaPermitidaParaNuevaReserva = cal.getTime();
	    
	    // Convertir LocalTime de la nueva reserva a Date para la comparación
	    Date inicioNuevaReserva = convertirALegacyDate(nuevaReserva.getHoraInicio());
	    
	    // La nueva reserva puede empezar después de la hora permitida
	    return inicioNuevaReserva.after(horaPermitidaParaNuevaReserva);
	}

	// Convierte un LocalTime a Date (para usar con Calendar)
	private Date convertirALegacyDate(LocalTime time) {
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.HOUR_OF_DAY, time.getHour());
	    cal.set(Calendar.MINUTE, time.getMinute());
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MILLISECOND, 0);
	    return cal.getTime();
	}
	

	@Override
    public String toString() {
        return nombreInstalacion; 
    }



	
	
	

}
