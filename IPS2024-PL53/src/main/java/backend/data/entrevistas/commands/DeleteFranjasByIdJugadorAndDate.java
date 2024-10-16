package backend.data.entrevistas.commands;

import java.util.Date;

import backend.data.Database;

public class DeleteFranjasByIdJugadorAndDate {
	
	private static final String QUERY = "DELETE FROM FRANJA_ENTREVISTA "
			+ "WHERE ID_JUGADOR = ? AND FECHA = ?";
	
	private Database db = new Database();
	private String idJugador;
	private Date fecha;
	
	public DeleteFranjasByIdJugadorAndDate(String idJugador, Date fecha) {
		this.idJugador = idJugador;
		this.fecha = fecha;
	}
	
	public void execute() {
		db.executeUpdate(QUERY, idJugador, fecha);
	}

}
