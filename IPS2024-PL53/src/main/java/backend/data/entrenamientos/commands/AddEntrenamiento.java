package backend.data.entrenamientos.commands;

import backend.data.Database;
import backend.data.entrenamientos.EntrenamientoDto;

public class AddEntrenamiento {


	private static final String QUERY = "INSERT INTO ENTRENAMIENTO (ID_ENTRENAMIENTO, FECHA, HORA_INICIO, "
			+ "HORA_FIN, COD_INSTALACION, ID_EQUIPO) VALUES (?, ?, ?, ?, ?, ?)";
	
	private EntrenamientoDto dto;
	private Database db = new Database();
	
	public AddEntrenamiento(EntrenamientoDto dto) {
		this.dto = dto;
	}
	
	public void execute() {
		db.executeUpdate(QUERY, dto.idEntrenamiento, dto.fecha, dto.horaInicio, dto.horaFinal, dto.codInstalacion, dto.idEquipo);
	}
}
