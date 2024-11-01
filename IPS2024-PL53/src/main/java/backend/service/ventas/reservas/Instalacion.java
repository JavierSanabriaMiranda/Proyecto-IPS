package backend.service.ventas.reservas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import backend.service.eventos.Entrenamiento;
import backend.service.horarios.FranjaTiempo;
import backend.service.horarios.TipoEvento;
import backend.service.reservaJardineria.ReservaJardineria;

public class Instalacion {
	private String nombreInstalacion;
	private List<Reserva> reservas = new ArrayList<Reserva>();
	private List<Entrenamiento> entrenamientos = new ArrayList<Entrenamiento>();
	private List<ReservaJardineria> reservasJardinerias = new ArrayList<>();
	
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
	
	public List<ReservaJardineria> getReservasJardineria(){
		return reservasJardinerias;
	}

	public List<FranjaTiempo> getEventos(LocalDate dia) {
		List<FranjaTiempo> lista = new ArrayList<FranjaTiempo>();
		for (Reserva reserva : reservas) {
			if (reserva.getHorario().getFecha().equals(dia)) { 
				lista.add(reserva.getHorario());
			}
		}
		for (Entrenamiento entrenamiento : entrenamientos) {
			if (entrenamiento.getHorario().getFecha().equals(dia)) {
				lista.add(entrenamiento.getHorario());
			}
		}
		for (ReservaJardineria reservaJar : reservasJardinerias) {
			if (reservaJar.getHorario().getFecha().equals(dia)) {
				lista.add(reservaJar.getHorario());
			}
		}
		return lista;
	}
	public List<FranjaTiempo> getEventosSinJardineria(LocalDate dia) {
		List<FranjaTiempo> lista = new ArrayList<FranjaTiempo>();
		for (Reserva reserva : reservas) {
			if (reserva.getHorario().getFecha().equals(dia)) { 
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
	
	public void addReservaJardineria(ReservaJardineria reserva) {
		this.reservasJardinerias.add(reserva);
	}


	/**
	 * Metodo para la reserva de instalaciones desde el punto de vista de un cliente
	 * 
	 * Se tendrá en cuenta la prioridad, en este caso al ser un cliente, si 
	 * hay una reserva de jardineria, en la franja seleccionada, se podrá reservar igual.
	 */
	public boolean esFranjaPosible(FranjaTiempo fj) {
	    // Duración mínima de la reserva: 60 minutos (1 hora)
	    if (fj.getDuracion() < 60) {
	        return false;
	    }

	    // Obtener eventos existentes en la fecha de la franja de tiempo propuesta
	    LocalDate fecha = fj.getFecha(); 
	    List<FranjaTiempo> eventosDelDia = getEventos(fecha);

	    for (FranjaTiempo evento : eventosDelDia) {
	        // Si la nueva franja se solapa con un evento existente
	        if (solapa(fj, evento) && evento.getEvento() != TipoEvento.RESERVA_JARDINERIA) {
	            return false;
	        }

	        // Verificar que la reserva no sea antes de 1h30 después de un evento, pero solo si es un entrenamiento
	        if (evento.getEvento() == TipoEvento.ENTRENAMIENTO && !puedeReservarDespuesDe(evento.getHoraFin(), fj.getHoraInicio())) {
	            return false;
	        }
	    }

	    // Si no hubo solapamientos ni conflictos con la restricción de 1h30, es posible
	    return true;
	}

	
	public List<ReservaJardineria> comprobarCoincidenciaConJardineria(FranjaTiempo fj) {
		List<ReservaJardineria> reservasCoincidentes = new ArrayList<>();
		for (ReservaJardineria reserva : reservasJardinerias) {
	    	if (solapa(fj, reserva.getHorario())) {
	    		reservasCoincidentes.add(reserva);
	    	}
	    }
		return reservasCoincidentes;
	}
	
	/**
	 * No se tiene en cuenta la hora y media de diferencia cuando la reserva es despues de un entrenamiento, ni la duracion minima
	 * Al ser la de menor prioridad, cuando solape con un evento cualquiera, devolverá false, incluso si es un evento de jardineria
	 * 
	 * Dos jardineros pueden trabajar juntos en la misma instalacion, a la misma hora, el mismo dia. 
	 */
	public boolean esFranjaPosibleParaJardinero(FranjaTiempo fj) {
	    // Obtener eventos existentes en la fecha de la franja de tiempo propuesta
	    LocalDate fecha = fj.getFecha(); 
	    List<FranjaTiempo> eventosDelDia = getEventosSinJardineria(fecha);

	    for (FranjaTiempo evento : eventosDelDia) {
	        // Si la nueva franja se solapa con un evento existente
	    	if (solapa(fj, evento)) {
	            return false;
	        }
	    }
	    return true;
	}
	

	// Verifica si dos franjas de tiempo se solapan
	private boolean solapa(FranjaTiempo nueva, FranjaTiempo existente) {
	    return nueva.getHoraInicio().isBefore(existente.getHoraFin()) && nueva.getHoraFin().isAfter(existente.getHoraInicio())
	    		 && !(nueva.getHoraFin().equals(existente.getHoraInicio()));
	}

	// Verifica si una reserva nueva puede realizarse después de 1h30 de un evento existente
	private boolean puedeReservarDespuesDe(LocalTime eventoHoraFin, LocalTime nuevaReservaHoraInicio) {
	    // Si la nueva reserva es antes o igual a la hora de finalización del evento, es válida
	    if (nuevaReservaHoraInicio.isBefore(eventoHoraFin)) {
	        return true;
	    }
	    
	    // Sumar 1 hora y 30 minutos a la hora de finalización del evento
	    LocalTime horaPermitida = eventoHoraFin.plusHours(1).plusMinutes(30);
	    
	    // Comprobar si la nueva reserva es igual o después de la hora permitida
	    return nuevaReservaHoraInicio.isAfter(horaPermitida) || nuevaReservaHoraInicio.equals(horaPermitida);
	}

	

	@Override
    public String toString() {
        return nombreInstalacion; 
    }



	
	
	

}
