package shared.gestionequipos.horarios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import backend.data.CreadorDataService;
import backend.data.empleados.DtoAssembler;
import backend.data.empleados.EmpleadoDeportivoDTO;
import backend.data.empleados.EmpleadosCRUDService;
import backend.data.entrenamientos.EntrenamientoCRUDImpl;
import backend.data.entrenamientos.EntrenamientoCRUDService;
import backend.data.entrenamientos.EntrenamientoDto;
import backend.data.entrenamientos.commands.DtoAssemblerEntrenamientos;
import backend.data.entrevistas.EntrevistaCRUDImpl;
import backend.data.entrevistas.EntrevistaCRUDService;
import backend.data.equipos.EquipoCRUDService;
import backend.data.equipos.command.DtoAssemblerEquipo;
import backend.data.reservaJardineria.ReservaJardineriaCRUDImpl;
import backend.data.reservaJardineria.ReservaJardineriaCRUDService;
import backend.data.reservaJardineria.ReservaJardineriaDTO;
import backend.data.ventas.VentasCRUDImpl;
import backend.data.ventas.VentasCRUDService;
import backend.data.ventas.commands.DtoAssemblerVentas;
import backend.service.empleados.EmpleadoDeportivo;
import backend.service.empleados.deportivos.Jugador;
import backend.service.empleados.nodeportivos.Gerente;
import backend.service.equipos.Equipo;
import backend.service.equipos.EquipoEnFormacion;
import backend.service.equipos.EquipoProfesional;
import backend.service.eventos.Entrenamiento;
import backend.service.horarios.FranjaTiempo;
import backend.service.horarios.TipoEvento;
import backend.service.reservaJardineria.ReservaJardineria;
import backend.service.usuarios.Usuario;
import backend.service.ventas.reservas.Instalacion;
import backend.service.ventas.reservas.Reserva;
import shared.gestionempleados.PuestoEmpleado;
import shared.gestionequipos.GestorEquipos;
import shared.gestioninstalaciones.GestorInstalaciones;
import shared.gestioninstalaciones.GestorReserva;
import util.DateToLocalDate;
import util.DateToLocalTimeConverter;

public class HorariosEntrenamientosShared {

	EmpleadosCRUDService serviceEmp = CreadorDataService.getEmpleadosService();
	EquipoCRUDService serviceEquip = CreadorDataService.getEquiposService();
	EntrenamientoCRUDService serviceEntr = new EntrenamientoCRUDImpl();
	EntrevistaCRUDService serviceEntrevista = new EntrevistaCRUDImpl();
	private GestorReserva gestorInstalaciones = new GestorInstalaciones();
	private GestorEquipos gestorEquipos = new Gerente();
	private Usuario usuario;
	
	public HorariosEntrenamientosShared(Usuario usuario) {
		this.usuario = usuario;
		
		cargaInstalaciones();
		cargarEquipos();
		cargarEmpleadosDeportivos();
		cargarReservaEnInstalaciones();
		cargarEntrenamientosEnInstalaciones();
		cargarReservaJardineriaEnInstalaciones();
	}
	
	private void cargarReservaJardineriaEnInstalaciones() {
		List<ReservaJardineria> reservasJardineria = cargarResevasJardineria();
		for (Instalacion inst : gestorInstalaciones.getInstalaciones()) {
			for (ReservaJardineria reserva : reservasJardineria) {
				if (reserva.getInstalacion().getNombreInstalacion().equals(inst.getNombreInstalacion()))
					inst.addReservaJardineria(reserva);
			}
		}
	}
	private List<ReservaJardineria> cargarResevasJardineria() {
		ReservaJardineriaCRUDService service = new ReservaJardineriaCRUDImpl();
		List<ReservaJardineriaDTO> dtos = service.cargarReservasJardineria();
		List<ReservaJardineria> reservas = new ArrayList<>();
		for(ReservaJardineriaDTO dto: dtos) {
			Instalacion inst = gestorInstalaciones.buscaInstalacion(dto.codInstalacion);
			FranjaTiempo franja = new FranjaTiempo(TipoEvento.RESERVA_JARDINERIA, DateToLocalTimeConverter.convertDateToLocalTime(dto.horaInicio),
					DateToLocalTimeConverter.convertDateToLocalTime(dto.horaFin), DateToLocalDate.convertToLocalDate(dto.fecha));
			//EmpleadoJardineria empleado = (EmpleadoJardineria) gestorJardineros.getEmpleadoNoDeportivo(dto.idJardinero);
			ReservaJardineria reserva = new ReservaJardineria(franja, inst, null, dto.codReservaJardineria);
			
			reservas.add(reserva);
		}
		
		return reservas;
	}
	
	private void cargarEmpleadosDeportivos() {
		List<EmpleadoDeportivo> lista = new ArrayList<EmpleadoDeportivo>();
		List<EmpleadoDeportivoDTO> empDeportivosDtos = serviceEmp.cargarEmpleadosDeportivos();
		for (EmpleadoDeportivoDTO dto : empDeportivosDtos) {
			Equipo equipo = gestorEquipos.getEquipoByID(dto.id_equipo);
			EmpleadoDeportivo emp = DtoAssembler.dtoToEmpleadoDeportivo(dto);
			emp.setEquipo(equipo);
			if (emp.getPuesto().equals(PuestoEmpleado.JUGADOR) && equipo != null)
				emp.addJugadorAEquipo(emp);
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
	
	public List<EmpleadoDeportivo> getEntrenadoresConEquipo(){
		if (usuario == null)
			return gestorEquipos.getEntrenadoresConEquipo();
		else {
			EmpleadoDeportivo entrenador = gestorEquipos.getEntrenadorUsuarioConEquipos(this.usuario.getIdUsuario());
			List<EmpleadoDeportivo> lista = new ArrayList<>();
			lista.add(entrenador);
			return lista;
		}
			
	}
	
	public List<FranjaTiempo> getEventos(Instalacion instalacion, LocalDate fecha) {
		return gestorInstalaciones.consultarDisponibilidad(instalacion, fecha);
	}
	
	public boolean isHorarioValido(Instalacion inst, FranjaTiempo franja) {
		return gestorInstalaciones.isHorarioValido(inst, franja);
	}
	
	public Instalacion buscaInstalacion(String nombreInstalacion) {
		return gestorInstalaciones.buscaInstalacion(nombreInstalacion);
	}

	public EmpleadoDeportivo buscaEmpleado(String idEntrenador) {
		return gestorEquipos.buscaEmpleado(idEntrenador);
	}

	public void addEntrenamiento(EmpleadoDeportivo entrenador, Instalacion instalacion, FranjaTiempo horario, Date fecha) {
		String idEntrenamiento = gestorInstalaciones.creaCodEntrenamiento();
		
		Entrenamiento entrenamiento = new Entrenamiento(idEntrenamiento, horario, instalacion, entrenador.getEquipo().getIdEquipo());
		
		//Añado el entrenamiento a la instalación
		gestorInstalaciones.addEntrenamientoAInstalacion(entrenamiento, instalacion);
		
		//Añado el entrenamiento a la lista de Entrenamientos del Equipo
		entrenador.getEquipo().addEntrenamiento(entrenamiento);
		
		//Añado el entrenamiento a la BDD
		addEntrenamientoABDD(instalacion, horario, entrenador, idEntrenamiento, fecha);
		
		//Borro la reserva de jardineria, las franjas de entrevista y las entrevistas (solo de BDD) si es que coincide con el entrenamiento
		borraReservaJardineriaCoincidente(horario, instalacion);
		
		//Borro si existe alguna entrevista o franja que coincida con el entrenamiento
		borraEntrevistaYFranjaDeBBDD(horario, entrenador.getEquipo());
	}

	private void addEntrenamientoABDD(Instalacion instalacion, FranjaTiempo horario, EmpleadoDeportivo entrenador, String idEntrenamiento, Date fecha) {
		EntrenamientoDto dto = new EntrenamientoDto();
		dto.codInstalacion = instalacion.getNombreInstalacion();
		dto.fecha = fecha;
		dto.horaFinal = DateToLocalTimeConverter.combinarFechaYHora(fecha, horario.getHoraFin());
		dto.horaInicio = DateToLocalTimeConverter.combinarFechaYHora(fecha, horario.getHoraInicio());
		dto.idEntrenamiento = idEntrenamiento;
		dto.idEquipo = entrenador.getEquipo().getIdEquipo();
		
		serviceEntr.addEntrenamiento(dto);
	}
	
	private void borraReservaJardineriaCoincidente(FranjaTiempo horario, Instalacion instalacion) {
		List<ReservaJardineria> reservaJardineria = gestorInstalaciones.comprobarCoincidenciaConJardineria(instalacion, horario);
		//Si es != null significa que la reserva coincide con la de un jardinero, asi que hay que borrar esa reserva
		if (!reservaJardineria.isEmpty()) {
			//Borrar reserva de la BBDD
			borrarReservaDeJardineriaDeBBDD(reservaJardineria);
			//Borrar reserva de la lista de reservas de la instalacion
			for(ReservaJardineria reservaJar : reservaJardineria) {
				gestorInstalaciones.getReservasJardineria().remove(reservaJar);
			}
		}
	}
	
	private void borrarReservaDeJardineriaDeBBDD(List<ReservaJardineria> reservas) {
		for(ReservaJardineria reserva :reservas) {
			ReservaJardineriaCRUDService service = new ReservaJardineriaCRUDImpl();
			service.deleteReservaJardineria(reserva.getCodReservaJardineria());
		}
	}
	
	private void borraEntrevistaYFranjaDeBBDD(FranjaTiempo horario, Equipo equipo) {
		for(Jugador jugador : equipo.getJugadores()) {
			serviceEntrevista.deleteEntrevistaYFranjaPorHora(horario, jugador.getIDEmpleado());
		}
	}

	public boolean entrenadorUsuarioTieneEquipo() {
		if (gestorEquipos.getEntrenadorUsuarioConEquipos(usuario.getIdUsuario()) == null)
			return false;
		return true;
	}

	
}
