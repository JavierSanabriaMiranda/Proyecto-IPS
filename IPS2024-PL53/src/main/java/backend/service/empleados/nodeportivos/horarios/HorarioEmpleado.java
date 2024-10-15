package backend.service.empleados.nodeportivos.horarios;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class HorarioEmpleado implements Horario {

	private Map<DayOfWeek, List<TurnoSemanal>> horarioSemanal = new HashMap<>();
	private Map<LocalDate, List<TurnoPuntual>> horarioPuntual = new HashMap<>();
	
	
	@Override
	public List<Turno> getHorarioDia(LocalDate dia) {
		if (horarioPuntual.containsKey(dia))
			return new ArrayList<Turno>(horarioPuntual.get(dia));
		else if (horarioSemanal.containsKey(dia.getDayOfWeek()))
			return new ArrayList<Turno>(horarioSemanal.get(dia.getDayOfWeek()));
		else
			return new ArrayList<Turno>();
	}

	@Override
	public Collection<List<TurnoSemanal>> getHorarioSemanal() {
		return horarioSemanal.values();
	}

	@Override
	public Collection<List<TurnoPuntual>> getHorarioPuntual() {
		return horarioPuntual.values();
	}

	@Override
	public TurnoPuntual addAHorarioPuntual(LocalTime inicio, LocalTime fin, LocalDate dia) {
		long horas = Duration.between(inicio, fin).toHours();
		if (isTurnoPuntualPermitido(dia, horas)) {
			TurnoPuntual turnoNuevo = new TurnoPuntual(UUID.randomUUID().toString(), inicio, fin, dia);
			addTurnoPuntual(turnoNuevo);
			return turnoNuevo;
		}
		return null;
	}

	/**
	 * Añade el turno puntual nuevo al map horarioPuntual
	 * @param turnoNuevo
	 */
	private void addTurnoPuntual(TurnoPuntual turnoNuevo) {
		LocalDate dia = turnoNuevo.getDia();
		if (horarioPuntual.containsKey(dia))
			horarioPuntual.get(dia).add(turnoNuevo);
		else {
			List<TurnoPuntual> turnos = new ArrayList<>();
			turnos.add(turnoNuevo);
			horarioPuntual.put(dia, turnos);
		}
			
	}

	@Override
	public TurnoSemanal addAHorarioSemanal(LocalTime inicio, LocalTime fin, DayOfWeek diaSemana) {
		long horas = Duration.between(inicio, fin).toHours();
		if (isTurnoSemanalPermitido(diaSemana, horas)) {
			TurnoSemanal turnoNuevo = new TurnoSemanal(UUID.randomUUID().toString(), inicio, fin, diaSemana);
			addTurnoSemanal(turnoNuevo);
			return turnoNuevo;
		}
		return null;
	}
	
	private void addTurnoSemanal(TurnoSemanal turnoNuevo) {
		DayOfWeek dia = turnoNuevo.getDiaSemana();
		if (horarioSemanal.containsKey(dia))
			horarioSemanal.get(dia).add(turnoNuevo);
		else {
			List<TurnoSemanal> turnos = new ArrayList<>();
			turnos.add(turnoNuevo);
			horarioSemanal.put(dia, turnos);
		}
	}

	/**
	 * Devuelve true si el nuevo turno a añadir está permitido en esa semana (no supera limites de horas)
	 * @param dia a añadir
	 * @param horas que ocupa el turno
	 * @return true si no supera los límites de horas, false en caso contrario
	 */
	private boolean isTurnoPuntualPermitido(LocalDate dia, long horas) {
		if (horas > 8)
			return false;
		
		long horasYaRegistradasEseDia = 0;
		// En caso de haber un horario puntual ya asignado a ese día, contamos las horas que ocupa
		if (horarioPuntual.containsKey(dia))
			for (TurnoPuntual turno : horarioPuntual.get(dia))
				horasYaRegistradasEseDia += turno.getHorasDuracion();
		// Si al sumar el turno nuevo se pasa de las 8 horas diarias
		if (horasYaRegistradasEseDia + horas > 8)
			return false;	
		
		long horasEsaSemana = contarHorasSemana(dia);
		
		// Si se superan las 40 horas semanales
		if (horasEsaSemana + horasYaRegistradasEseDia + horas > 40)
			return false;
		return true;
	}
	
	private boolean isTurnoSemanalPermitido(DayOfWeek diaSemana, long horas) {
		if (horas > 8)
			return false;
		
		long horasYaRegistradasEseDia = 0;
		
		// En caso de haber un horario semanal ya asignado a ese día, contamos las horas que ocupa
		if (horarioSemanal.containsKey(diaSemana))
			for (TurnoSemanal turno : horarioSemanal.get(diaSemana))
				horasYaRegistradasEseDia += turno.getHorasDuracion();
		// Si al sumar el turno nuevo se pasa de las 8 horas diarias
		if (horasYaRegistradasEseDia + horas > 8)
			return false;
		
		long horasEsaSemana = contarHorasHorarioSemanal();
		// Si se superan las 40 horas semanales
		if (horasEsaSemana + horas > 40)
			return false;
		return true;
	}
	
	/**
	 * Cuenta las horas de trabajo para el día introducido, priorizando los horarios puntuales por encima de 
	 * los horarios regulares
	 */
	private long contarHorasDia(LocalDate dia) {
		long horas = 0;
		// Cuenta las horas si se aplica un horario puntual para ese día
		if (horarioPuntual.containsKey(dia)) {
			for (TurnoPuntual turno : horarioPuntual.get(dia)) 
				horas += turno.getHorasDuracion();
			return horas;
		}
		// Cuenta las horas si se aplica un horario periódico para ese día
		else if (horarioSemanal.containsKey(dia.getDayOfWeek())) {
			for (TurnoSemanal turno : horarioSemanal.get(dia.getDayOfWeek()))
				horas += turno.getHorasDuracion();
			return horas;
		}
		return horas;
	}

	/**
	 * Cuenta las horas de trabajo que hay la semana del día introducido, sin contar las horas del dia introducido
	 */
	private long contarHorasSemana(LocalDate dia) {
		long horas = 0;
		int diaSemana = dia.getDayOfWeek().getValue();
		// Cuenta las horas que tienen los días anteriores de la semana
		for (int i = 1; i < diaSemana; i++)
			horas += contarHorasDia(LocalDate.ofYearDay(dia.getYear(), dia.getDayOfYear()-i));
		// Cuenta las horas que tienen los dias posteriores de la semana
		for (int i = 7; i > diaSemana; i--)
			horas += contarHorasDia(LocalDate.ofYearDay(dia.getYear(), dia.getDayOfYear()+i-diaSemana));
		
		return horas;
	}
	
	private long contarHorasHorarioSemanal() {
		long horasSemana = 0;
		
		for (List<TurnoSemanal> turnos : horarioSemanal.values())
			for (TurnoSemanal turno : turnos)
				horasSemana += turno.getHorasDuracion();
		
		return horasSemana;
	}

}
