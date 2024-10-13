package shared.gestionhorarios;

import java.time.LocalDate;
import java.util.List;

import backend.data.CreadorDataService;
import backend.data.empleados.DtoAssembler;
import backend.data.empleados.EmpleadosCRUDService;
import backend.data.horarios.HorarioCRUDService;
import backend.data.horarios.TurnoPuntualDTO;
import backend.data.horarios.TurnoSemanalDTO;
import backend.service.empleados.EmpleadoNoDeportivo;
import backend.service.empleados.nodeportivos.Gerente;
import backend.service.empleados.nodeportivos.horarios.Turno;

public class GestionHorariosShared {

	private GestorHorarios gestor = new Gerente();
	EmpleadosCRUDService serviceEmp = CreadorDataService.getEmpleadosService();
	HorarioCRUDService serviceHor = CreadorDataService.getHorarioService();

	public GestionHorariosShared() {
		cargarEmpleadosNoDeportivosDeBBDD();
		cargarHorariosDeBBDD();
	}

	public List<Turno> getHorario(EmpleadoNoDeportivo emp, LocalDate fecha) {
		return gestor.getHorarioDia(emp, fecha);
	}

	public List<EmpleadoNoDeportivo> getEmpleadosNoDeportivosFromGestor() {
		return gestor.getEmpleadosNoDeportivos();
	}
	
	private void cargarEmpleadosNoDeportivosDeBBDD() {
		List<EmpleadoNoDeportivo> empleados = DtoAssembler.dtoToEmpleadoNoDeportivo(serviceEmp.cargarEmpleadosNoDeportivos());
		for (EmpleadoNoDeportivo emp : empleados)
			gestor.addEmpleadoNoDeportivo(emp);
	}
	
	private void cargarHorariosDeBBDD() {
		cargarTurnosSemanales();
		cargarTurnosPuntuales();
	}

	private void cargarTurnosSemanales() {
		List<TurnoSemanalDTO> dtosSemanales = serviceHor.cargarTurnosSemanales();
		for (TurnoSemanalDTO dtoSemanal : dtosSemanales) {
			EmpleadoNoDeportivo emp = gestor.getEmpleadoNoDeportivo(dtoSemanal.idEmp);
			emp.getHorario().addAHorarioSemanal(dtoSemanal.horaInicio, dtoSemanal.horaFin, dtoSemanal.diaSemana);
		}
	}
	
	private void cargarTurnosPuntuales() {
		List<TurnoPuntualDTO> dtosPuntuales = serviceHor.cargarTurnosPuntuales();
		for (TurnoPuntualDTO dtoPuntual : dtosPuntuales) {
			EmpleadoNoDeportivo emp = gestor.getEmpleadoNoDeportivo(dtoPuntual.idEmp);
			emp.getHorario().addAHorarioPuntual(dtoPuntual.horaInicio, dtoPuntual.horaFin, dtoPuntual.dia);
		}
	}
	
}
