package backend.data.entrevistas.commands;

import java.sql.Time;
import java.sql.Date;

import backend.data.Database;
import backend.service.horarios.FranjaTiempo;

public class DeleteEntrevistaYFranjaPorHora {

	private static final String QUERY_FRANJA = 
		    "DELETE FROM FRANJA_ENTREVISTA WHERE FECHA = ? AND " +
		    "((HORA_INICIO < ? AND HORA_FIN > ?) OR " +
		    "(HORA_INICIO >= ? AND HORA_INICIO < ?) OR " +
		    "(HORA_FIN > ? AND HORA_FIN <= ?)) AND ID_JUGADOR = ?";

		private static final String QUERY_ENTREVISTA = 
		    "DELETE FROM ENTREVISTA WHERE FECHA = ? AND " +
		    "((HORA_INICIO < ? AND HORA_FIN > ?) OR " +
		    "(HORA_INICIO >= ? AND HORA_INICIO < ?) OR " +
		    "(HORA_FIN > ? AND HORA_FIN <= ?)) AND ID_JUGADOR = ?";

	
	
	private Database db = new Database();
	private FranjaTiempo franjaEntrevista;
	private String idJugador;
	
	public DeleteEntrevistaYFranjaPorHora(FranjaTiempo franjaEntrevista, String idJugador) {
		this.franjaEntrevista = franjaEntrevista;
		this.idJugador = idJugador;
	}
	
	public void execute() {
	    Date fecha = Date.valueOf(franjaEntrevista.getFecha());
	    Time horaInicio = Time.valueOf(franjaEntrevista.getHoraInicio());
	    Time horaFin = Time.valueOf(franjaEntrevista.getHoraFin());

	    db.executeUpdate(QUERY_ENTREVISTA, 
	            fecha, 
	            horaInicio, 
	            horaFin, 
	            horaInicio, 
	            horaFin, 
	            horaInicio, 
	            horaFin, 
	            idJugador);

	    db.executeUpdate(QUERY_FRANJA, 
	            fecha, 
	            horaInicio, 
	            horaFin, 
	            horaInicio, 
	            horaFin, 
	            horaInicio, 
	            horaFin, 
	            idJugador);
	}

}
