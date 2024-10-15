package backend.data.horarios.commands;

import backend.data.Database;
import backend.data.horarios.TurnoSemanalDTO;

public class AddTurnoSemanal {

	private static final String QUERY_TURNO = "INSERT INTO TURNO "
			+ "(ID_TURNO, ID_EMPLEADO, HORA_INICIO, HORA_FIN) "
			+ "VALUES (?, ?, ?, ?)";
	private static final String QUERY_TURNO_SEMANAL = "INSERT INTO TURNO_SEMANAL "
			+ "(ID_TURNO, ID_EMPLEADO, DIA_SEMANA) "
			+ "VALUES (?, ?, ?)";
	
	private TurnoSemanalDTO dto;
	private Database db = new Database();
	
	public AddTurnoSemanal(TurnoSemanalDTO dto) {
		this.dto = dto;
	}

	public void execute() {
		db.executeUpdate(QUERY_TURNO, dto.idTurno, dto.idEmp, dto.horaInicio, dto.horaFin);
		db.executeUpdate(QUERY_TURNO_SEMANAL, dto.idTurno, dto.idEmp, dto.diaSemana.getValue());
	}

}
