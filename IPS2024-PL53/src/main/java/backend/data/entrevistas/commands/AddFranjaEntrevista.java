package backend.data.entrevistas.commands;

import backend.data.CreadorDataService;
import backend.data.Database;
import backend.data.entrevistas.EntrevistaCRUDService;
import backend.data.entrevistas.FranjaEntrevistaDTO;
import backend.util.FranjaEntrevistaException;

public class AddFranjaEntrevista {

	private Database db = new Database();
	private FranjaEntrevistaDTO franja;
	
	private static final String QUERY = "INSERT INTO FRANJA_ENTREVISTA "
			+ "(ID_JUGADOR, FECHA, HORA_INICIO, HORA_FIN)"
			+ "VALUES (?, ?, ?, ?)";
	
	
	public AddFranjaEntrevista(FranjaEntrevistaDTO franja) {
		this.franja = franja;
	}
	
	public void execute() throws FranjaEntrevistaException {
		if (!checkIfJugadorTieneEntrevista()) {
		db.executeUpdate(QUERY, franja.id_jugador, franja.fecha
				, franja.hora_inicio, franja.hora_fin);
		} else {
			throw new FranjaEntrevistaException("El jugador ya tiene una entrevista fechada para ese dia");
		}
	}
	
	private boolean checkIfJugadorTieneEntrevista() {
		EntrevistaCRUDService servicio = CreadorDataService.getEntrevistaService();
		return servicio.findEntrevistaByJugadorIdAndDate(franja.id_jugador, franja.fecha) != null;
	}
}
