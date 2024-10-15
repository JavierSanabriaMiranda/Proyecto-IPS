package backend.data.horarios.commands;

import backend.data.Database;
import backend.data.horarios.TurnoPuntualDTO;

public class AddTurnoPuntual {
	
	private static final String QUERY_TURNO = "INSERT INTO TURNO "
			+ "(ID_TURNO, ID_EMPLEADO, HORA_INICIO, HORA_FIN) "
			+ "VALUES (?, ?, ?, ?)";
	private static final String QUERY_TURNO_PUNTUAL = "INSERT INTO TURNO_PUNTUAL "
			+ "(ID_TURNO, ID_EMPLEADO, DIA) "
			+ "VALUES (?, ?, ?)";
	
	private TurnoPuntualDTO dto;
	private Database db = new Database();
	
	public AddTurnoPuntual(TurnoPuntualDTO dto) {
		this.dto = dto;
	}


	public void execute() {
		db.executeUpdate(QUERY_TURNO, dto.idTurno, dto.idEmp, dto.horaInicio, dto.horaFin);
		db.executeUpdate(QUERY_TURNO_PUNTUAL, dto.idTurno, dto.idEmp, dto.dia);
	}
	
	
	

}
