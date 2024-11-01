package shared.gestionequipos.horarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import backend.data.CreadorDataService;
import backend.data.empleados.DtoAssembler;
import backend.data.empleados.EmpleadoDeportivoDTO;
import backend.data.empleados.EmpleadosCRUDService;
import backend.data.entrenamientos.EntrenamientoCRUDImpl;
import backend.data.entrenamientos.EntrenamientoCRUDService;
import backend.data.entrenamientos.commands.DtoAssemblerEntrenamientos;
import backend.data.equipos.EquipoCRUDService;
import backend.data.equipos.command.DtoAssemblerEquipo;
import backend.data.ventas.VentasCRUDImpl;
import backend.data.ventas.VentasCRUDService;
import backend.data.ventas.commands.DtoAssemblerVentas;
import backend.service.empleados.EmpleadoDeportivo;
import backend.service.empleados.nodeportivos.Gerente;
import backend.service.equipos.Equipo;
import backend.service.equipos.EquipoEnFormacion;
import backend.service.equipos.EquipoProfesional;
import backend.service.eventos.Entrenamiento;
import backend.service.horarios.FranjaTiempo;
import backend.service.ventas.reservas.Instalacion;
import backend.service.ventas.reservas.Reserva;
import shared.gestionequipos.GestorEquipos;
import shared.gestioninstalaciones.GestorInstalaciones;
import shared.gestioninstalaciones.GestorReserva;

public class HorariosEntrenamientosShared {

	EmpleadosCRUDService serviceEmp = CreadorDataService.getEmpleadosService();
	EquipoCRUDService serviceEquip = CreadorDataService.getEquiposService();
	private GestorReserva gestorInstalaciones = new GestorInstalaciones();
	private GestorEquipos gestorEquipos = new Gerente();
	
	public HorariosEntrenamientosShared() {
		cargaInstalaciones();
		cargarEmpleadosDeportivos();
		cargarEquipos();
		cargarReservaEnInstalaciones();
		cargarEntrenamientosEnInstalaciones();
	}
	
	private void cargarEmpleadosDeportivos() {
		List<EmpleadoDeportivo> lista = new ArrayList<EmpleadoDeportivo>();
		List<EmpleadoDeportivoDTO> empDeportivosDtos = serviceEmp.cargarEmpleadosDeportivos();
		for (EmpleadoDeportivoDTO dto : empDeportivosDtos) {
			Equipo equipo = gestorEquipos.getEquipoByID(dto.id_equipo);
			EmpleadoDeportivo emp = DtoAssembler.dtoToEmpleadoDeportivo(dto);
			emp.setEquipo(equipo);
			lista.add(emp);
		}

		cargarEmpleadosDeportivosEnGestor(lista);
	}

	private void cargarEmpleadosDeportivosEnGestor(List<EmpleadoDeportivo> empleadosDeportivos) {
		for (EmpleadoDeportivo emp : empleadosDeportivos) {
			gestorEquipos.addEmpleadoDeportivo(emp);
		}
	}
	
	
	private void cargarEquipos() {
		// Cargo los equipos profesionales
		List<EquipoProfesional> equiposPros = DtoAssemblerEquipo
				.dtoToEquipoProfesional(serviceEquip.cargarEquipoProfesional());
		for (EquipoProfesional equipo : equiposPros) {
			gestorEquipos.addEquipo(equipo);
		}
		// Cargo los equipos en formacion
		List<EquipoEnFormacion> equiposFor = DtoAssemblerEquipo
				.dtoToEquipoEnFormacion(serviceEquip.cargarEquipoEnFormacion());
		for (EquipoEnFormacion equipo : equiposFor) {
			gestorEquipos.addEquipo(equipo);
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

	private List<Instalacion> cargaInstalaciones(){
		 return gestorInstalaciones.cargarInstalaciones();
	}
	

	public List<Instalacion> getInstalaciones(){
		return gestorInstalaciones.getInstalaciones();
	}

	public GestorEquipos getGestorEquipos() {
		return gestorEquipos;
	}
	
	public List<EmpleadoDeportivo> getEntrenadores(){
		return gestorEquipos.getEntrenadores();
	}
	
	public List<FranjaTiempo> getEventos(Instalacion instalacion, LocalDate fecha) {
		return gestorInstalaciones.consultarDisponibilidad(instalacion, fecha);
	}
	
	public boolean isHorarioValido(Instalacion inst, FranjaTiempo franja) {
		return gestorInstalaciones.isHorarioValido(inst, franja);
	}


}
