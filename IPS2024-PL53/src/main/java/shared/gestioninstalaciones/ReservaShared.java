package shared.gestioninstalaciones;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import backend.service.empleados.GestorInstalaciones;
import backend.service.horarios.FranjaTiempo;
import backend.service.ventas.reservas.Instalacion;

public class ReservaShared {

	
	GestorReserva gestor = new GestorInstalaciones();
	
	
	public List<FranjaTiempo> getEventos(Instalacion instalacion, Date fecha) {
		return extracted();
		
		//return gestor.consultarDisponibilidad(instalacion, fecha);
	}

	/**
	 * Test para que se me genere el panel Horario
	 * @return
	 */
	private List<FranjaTiempo> extracted() {
		List<FranjaTiempo> lista = new ArrayList<FranjaTiempo>();
		Date fechaActual = new Date();
		 Calendar calendar = Calendar.getInstance();
	        calendar.set(2024, Calendar.OCTOBER, 3, 0, 0, 0); // Año, mes (0-11), día, hora, minuto, segundo
	        calendar.set(Calendar.MILLISECOND, 0); 
		FranjaTiempo franja = new FranjaTiempo("Entrenamiento Equipo",  LocalTime.of(14, 30) , LocalTime.of(15, 30),fechaActual );
		Date fecha = new Date();
		 Calendar calendaro = Calendar.getInstance();
	        calendaro.set(2024, Calendar.OCTOBER, 3, 0, 0, 0); // Año, mes (0-11), día, hora, minuto, segundo
	        calendaro.set(Calendar.MILLISECOND, 0); 
		FranjaTiempo g = new FranjaTiempo("Reserva",  LocalTime.of(19, 30) , LocalTime.of(20, 30),fecha );
		lista.add(g);
		lista.add(franja);
		return lista;
	}
	
	public Instalacion buscaInstalacion(String nombreInst) {
		return gestor.buscaInstalacion(nombreInst);
	}
	
	public boolean isHorarioValido(Instalacion inst, FranjaTiempo franja) {
		return gestor.isHorarioValido(inst, franja);
	}
}
