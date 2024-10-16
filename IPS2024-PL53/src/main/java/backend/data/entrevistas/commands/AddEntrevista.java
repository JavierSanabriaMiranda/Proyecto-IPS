package backend.data.entrevistas.commands;

import backend.data.Database;
import backend.data.entrevistas.EntrevistaDTO;

public class AddEntrevista {

	private Database db = new Database();
	private EntrevistaDTO entrevista;
	
	private static final String QUERY = "INSERT INTO ENTREVISTA "
			+ "(COD_ENTREVISTA, ID_JUGADOR, FECHA, HORA_INICIO, HORA_FIN, MEDIO_COMUNICACION)"
			+ "VALUES (?, ?, ?, ?, ?, ?)";
	
	
	public AddEntrevista(EntrevistaDTO entrevista) {
		this.entrevista = entrevista;
	}
	
	public void execute() {
		db.executeUpdate(QUERY, entrevista.cod_entrevista, entrevista.id_jugador
				, entrevista.fecha, entrevista.hora_inicio, entrevista.hora_fin
				, entrevista.medio_comunicacion);
	}
}
