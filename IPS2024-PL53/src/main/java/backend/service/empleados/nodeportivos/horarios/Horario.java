package backend.service.empleados.nodeportivos.horarios;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

public interface Horario {
	
	/**
	 * Devuelve el horario en forma de lista de turnos, que está asignado para la 
	 * fecha introducida como parámetro. En caso de no haber horario para dicho día, devuelve una lista vacía
	 *  
	 * @param dia del horario a obtener
	 * @return lista de turnos que representan el horario de ese día y, si no lo hay, lista vacía
	 */
	List<Turno> getHorarioDia(LocalDate dia);
	Collection<List<TurnoSemanal>> getHorarioSemanal();
	Collection<List<TurnoPuntual>> getHorarioPuntual();
	boolean addAHorarioPuntual(LocalTime inicio, LocalTime fin, LocalDate dia);
	boolean addAHorarioSemanal(LocalTime inicio, LocalTime fin, DayOfWeek diaSemana);
}
