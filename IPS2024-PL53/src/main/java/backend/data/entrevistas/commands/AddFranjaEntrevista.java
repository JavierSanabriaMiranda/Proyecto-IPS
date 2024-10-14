package backend.data.entrevistas.commands;

import backend.data.Database;
import backend.data.entrevistas.FranjaEntrevistaDTO;

public class AddFranjaEntrevista {

	private Database db = new Database();
	private FranjaEntrevistaDTO franja;
	
	private static final String QUERY = "INSERT INTO FRANJA_ENTREVISTA "
			+ "(ID_JUGADOR, FECHA, HORA_INICIO, HORA_FIN)"
			+ "VALUES (?, ?, ?, ?)";
	
	
	public AddFranjaEntrevista(FranjaEntrevistaDTO franja) {
		this.franja = franja;
	}
	
	public void execute() {
		db.executeUpdate(QUERY, franja.id_jugador, franja.fecha
				, franja.hora_inicio, franja.hora_fin);
	}
}
