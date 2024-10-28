package shared.gestionjardineria;

import java.time.LocalDate;
import java.util.List;

import backend.data.CreadorDataService;
import backend.data.empleados.DtoAssembler;
import backend.data.empleados.EmpleadosCRUDService;
import backend.data.entrenamientos.EntrenamientoCRUDImpl;
import backend.data.entrenamientos.EntrenamientoCRUDService;
import backend.data.entrenamientos.commands.DtoAssemblerEntrenamientos;
import backend.data.horarios.HorarioCRUDService;
import backend.data.horarios.TurnoPuntualDTO;
import backend.data.horarios.TurnoSemanalDTO;
import backend.data.ventas.VentasCRUDImpl;
import backend.data.ventas.VentasCRUDService;
import backend.data.ventas.commands.DtoAssemblerVentas;
import backend.service.empleados.EmpleadoNoDeportivo;
import backend.service.empleados.nodeportivos.Gerente;
import backend.service.empleados.nodeportivos.horarios.Turno;
import backend.service.eventos.Entrenamiento;
import backend.service.horarios.FranjaTiempo;
import backend.service.ventas.reservas.Instalacion;
import backend.service.ventas.reservas.Reserva;
import shared.gestioninstalaciones.GestorInstalaciones;
import shared.gestioninstalaciones.GestorReserva;

public class JardinerosShared {
	
	private GestorJardineros gestor = new Gerente();
	GestorReserva gestorInstalaciones = new GestorInstalaciones();
	EmpleadosCRUDService serviceEmp = CreadorDataService.getEmpleadosService();
	HorarioCRUDService serviceHor = CreadorDataService.getHorarioService();
	
	public JardinerosShared() {
		cargarEmpleadosNoDeportivos();
		cargarInstalaciones();
		cargarReservaEnInstalaciones();
		cargarEntrenamientosEnInstalaciones();
		cargarHorariosDeBBDD();
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
	private void cargarReservaEnInstalaciones() {
		List<Reserva> reservas = cargarReservas();
		for (Instalacion inst : gestorInstalaciones.getInstalaciones()) {
			for (Reserva reserva : reservas) {
				if (reserva.getInstalacion().getNombreInstalacion().equals(inst.getNombreInstalacion()))
					inst.addReserva(reserva);
			}
		}
	}
	
	private void cargarEntrenamientosEnInstalaciones() {
		List<Entrenamiento> entrenamientos = cargarEntrenamientos();
		for (Instalacion inst : gestorInstalaciones.getInstalaciones()) {
			for (Entrenamiento entrenamiento : entrenamientos) {
				if (entrenamiento.getInstalacion().getNombreInstalacion().equals(inst.getNombreInstalacion()))
					inst.addEntrenamiento(entrenamiento);
			}
		}
	}
	
	private List<Entrenamiento> cargarEntrenamientos() {
		EntrenamientoCRUDService service = new EntrenamientoCRUDImpl();
		DtoAssemblerEntrenamientos assembler = new DtoAssemblerEntrenamientos(gestorInstalaciones);
		return assembler.dtoToEntrenamiento(service.cargarEntrenamientos());
	}

	private List<Reserva> cargarReservas() {
		VentasCRUDService service = new VentasCRUDImpl();
		DtoAssemblerVentas assembler = new DtoAssemblerVentas(gestorInstalaciones);
		return assembler.dtoToReserva(service.cargarReservas());
	}
	private void cargarInstalaciones() {
		gestorInstalaciones.cargarInstalaciones();
	}

	private void cargarEmpleadosNoDeportivos() {
		List<EmpleadoNoDeportivo> empleados = DtoAssembler.dtoToEmpleadoNoDeportivo(serviceEmp.cargarEmpleadosNoDeportivos());
		for (EmpleadoNoDeportivo emp : empleados)
			gestor.addEmpleadoNoDeportivo(emp);
	}

	public List<EmpleadoNoDeportivo> getJardineros(){
		return gestor.getJardineros();
	}
	
	public List<Instalacion> getInstalaciones(){
		return gestorInstalaciones.getInstalaciones();
	}
	
	public List<Turno> getHorario(EmpleadoNoDeportivo emp, LocalDate fecha) {
		return gestor.getHorarioDia(emp, fecha);
	}
	
	public List<FranjaTiempo> getEventos(Instalacion instalacion, LocalDate fecha) {
		return gestorInstalaciones.consultarDisponibilidad(instalacion, fecha);
	}

	public boolean isHorarioValidoParaJardinero(Instalacion instalacion, FranjaTiempo franja) {
		return gestorInstalaciones.isHorarioValidoParaJardinero(instalacion, franja);
	}


}
