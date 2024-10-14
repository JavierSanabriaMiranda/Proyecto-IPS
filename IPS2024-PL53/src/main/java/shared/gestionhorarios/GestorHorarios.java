package shared.gestionhorarios;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import backend.service.empleados.EmpleadoNoDeportivo;
import backend.service.empleados.nodeportivos.horarios.Turno;

public interface GestorHorarios {
	
	List<EmpleadoNoDeportivo> getEmpleadosNoDeportivos();

	/**
	 * Añade un empleado que ya tiene ID a la lista de empleados no deportivos 
	 * @param emp a añadir
	 */
	void addEmpleadoNoDeportivo(EmpleadoNoDeportivo emp);

	/**
	 * Devuelve una lista con los turnos asignados para el empleado indicado, en la fecha indicada. Si no hay empleado
	 * con horario en esa fecha, devuelve una lista vacia
	 */
	List<Turno> getHorarioDia(EmpleadoNoDeportivo emp, LocalDate fecha);

	EmpleadoNoDeportivo getEmpleadoNoDeportivo(String idEmp);
	
	boolean addTurnoSemanal(String idEmp, LocalTime hInicio, LocalTime hFin, DayOfWeek diaSemana);

	boolean addTurnoPuntual(String idEmpleado, LocalTime hInicio, LocalTime hFin, LocalDate dia);
}
