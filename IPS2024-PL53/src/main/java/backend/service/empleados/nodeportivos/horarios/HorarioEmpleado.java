package backend.service.empleados.nodeportivos.horarios;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import backend.service.horarios.FranjaTiempo;

public class HorarioEmpleado implements Horario {

	private Map<DayOfWeek, List<FranjaTiempo>> horarioSemanal = new HashMap<>();
	private Map<LocalDate, List<FranjaTiempo>> horarioPuntual = new HashMap<>();
	
	@Override
	public List<FranjaTiempo> getHorarioDia(LocalDate dia) {
		if (horarioPuntual.containsKey(dia))
			return horarioPuntual.get(dia);
		else if (horarioSemanal.containsKey(dia.getDayOfWeek()))
			return horarioSemanal.get(dia.getDayOfWeek());
		else
			return new ArrayList<FranjaTiempo>();
	}
	
	
}
