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

import backend.service.horarios.FranjaTiempo;

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
	public boolean addAHorarioPuntual(LocalTime inicio, LocalTime fin, LocalDate dia) {
		long horas = Duration.between(inicio, fin).toHours();
		if (isHorarioPuntualPermitido(dia, horas)) {
			//TurnoPuntual turnoNuevo = new TurnoPuntual(inicio, fin, dia); TODO comprobar forma de añadir turnos con Id
			return true;
		}
		return false;
	}

	@Override
	public boolean addAHorarioSemanal(LocalTime inicio, LocalTime fin, DayOfWeek diaSemana) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Devuelve true si el nuevo turno a añadir está permitido en esa semana (no supera limites de horas)
	 * @param dia a añadir
	 * @param horas que ocupa el turno
	 * @return true si no supera los límites de horas, false en caso contrario
	 */
	private boolean isHorarioPuntualPermitido(LocalDate dia, long horas) {
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
	 * @param dia
	 * @return
	 */
	private long contarHorasSemana(LocalDate dia) {
		long horas = 0;
		int diaSemana = dia.getDayOfWeek().getValue();
		// Cuenta las horas que tienen los días anteriores de la semana
		for (int i = 1; i < diaSemana; i++)
			horas += contarHorasDia(LocalDate.ofYearDay(dia.getYear(), dia.getDayOfYear()-i));
		// Cuenta las horas que tienen los dias posteriores de la semana
		for (int i = 7; i > diaSemana; i--)
			horas += contarHorasDia(LocalDate.ofYearDay(dia.getYear(), dia.getDayOfYear()+i));
		
		return horas;
	}

}
