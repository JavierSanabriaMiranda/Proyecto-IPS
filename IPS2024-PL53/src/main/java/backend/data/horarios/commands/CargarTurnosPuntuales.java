package backend.data.horarios.commands;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import backend.data.Database;
import backend.data.horarios.TurnoPuntualDTO;
import backend.data.horarios.TurnoSemanalDTO;

public class CargarTurnosPuntuales {

	private static final String QUERY = "SELECT "
			+ "T.ID_TURNO AS idTurno, "
			+ "T.ID_EMPLEADO AS idEmp, "
			+ "T.HORA_INICIO AS hInicio, "
			+ "T.HORA_FIN AS hFin, "
			+ "TP.DIA AS dia "
			+ "FROM TURNO T "
			+ "INNER JOIN TURNO_PUNTUAL TP ON T.ID_TURNO = TP.ID_TURNO "
			+ "AND T.ID_EMPLEADO = TP.ID_EMPLEADO";
			
	private Database db = new Database();


	public List<TurnoPuntualDTO> execute() {
		List<Map<String, Object>> mapsTurnos = db.executeQueryMap(QUERY);
		List<TurnoPuntualDTO> turnos = mapsToHorarios(mapsTurnos);
		
		return turnos;
	}
	
	private List<TurnoPuntualDTO> mapsToHorarios(List<Map<String, Object>> mapsHorarios) {
		List<TurnoPuntualDTO> turnos = new ArrayList<>();
		
		for (Map<String, Object> fila : mapsHorarios) {
			TurnoPuntualDTO dto = new TurnoPuntualDTO(); 
	        dto.idTurno = (String) fila.get("idTurno");
	        
	        // Conversión de sql.Time a LocalTime
	        Time inicio = (Time) fila.get("hInicio");
	        dto.horaInicio = inicio.toLocalTime();
	        Time fin = (Time) fila.get("hFin");
	        dto.horaFin = fin.toLocalTime();
	        
	        dto.idEmp = (String) fila.get("idEmp");
	        dto.codHorario = (String) fila.get("codHorario");
	        
	        Date dia = (Date) fila.get("dia");
	        dto.dia = dia.toLocalDate();
	        
	        turnos.add(dto);
	    }
	    return turnos; 
	}
}
