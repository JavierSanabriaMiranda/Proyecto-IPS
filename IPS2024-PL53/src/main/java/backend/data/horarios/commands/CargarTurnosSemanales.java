package backend.data.horarios.commands;

import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import backend.data.Database;
import backend.data.horarios.TurnoSemanalDTO;

public class CargarTurnosSemanales {
	
	private static final String QUERY = "SELECT "
			+ "T.ID_TURNO AS idTurno, "
			+ "T.ID_EMPLEADO AS idEmp, "
			+ "T.HORA_INICIO AS hInicio, "
			+ "T.HORA_FIN AS hFin, "
			+ "TS.DIA_SEMANA AS diaSemana "
			+ "FROM TURNO T "
			+ "INNER JOIN TURNO_SEMANAL TS ON T.ID_TURNO = TS.ID_TURNO "
			+ "AND T.ID_EMPLEADO = TS.ID_EMPLEADO";
			
	private Database db = new Database();

	public List<TurnoSemanalDTO> execute() {
		List<Map<String, Object>> mapsTurnos = db.executeQueryMap(QUERY);
		List<TurnoSemanalDTO> turnos = mapsToHorarios(mapsTurnos);
		
		return turnos;
	}
	
	private List<TurnoSemanalDTO> mapsToHorarios(List<Map<String, Object>> mapsHorarios) {
		List<TurnoSemanalDTO> turnos = new ArrayList<>();
		
		for (Map<String, Object> fila : mapsHorarios) {
			TurnoSemanalDTO dto = new TurnoSemanalDTO(); 
	        dto.idTurno = (String) fila.get("idTurno");
	        
	        // Conversión de sql.Time a LocalTime
	        Time inicio = (Time) fila.get("hInicio");
	        dto.horaInicio = inicio.toLocalTime();
	        Time fin = (Time) fila.get("hFin");
	        dto.horaFin = fin.toLocalTime();
	        
			dto.idEmp = (String) fila.get("idEmp");
	        
	        // Conversión de int a dia de la semana
	        int diaSemana = (int) fila.get("diaSemana");
	        dto.diaSemana = DayOfWeek.of(diaSemana);
	        
	        turnos.add(dto);
	    }
	    return turnos; 
	}
}
