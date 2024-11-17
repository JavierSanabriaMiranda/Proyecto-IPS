package shared.gestionequipos.partidos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import backend.data.CreadorDataService;
import backend.data.empleados.DtoAssembler;
import backend.data.empleados.EmpleadoDeportivoDTO;
import backend.data.empleados.EmpleadosCRUDService;
import backend.data.entrevistas.EntrevistaCRUDImpl;
import backend.data.entrevistas.EntrevistaCRUDService;
import backend.data.equipos.EquipoCRUDService;
import backend.data.equipos.command.DtoAssemblerEquipo;
import backend.data.partidos.PartidoDTO;
import backend.data.partidos.PartidosCRUDImpl;
import backend.data.partidos.PartidosCRUDService;
import backend.service.empleados.EmpleadoDeportivo;
import backend.service.empleados.deportivos.Jugador;
import backend.service.empleados.nodeportivos.Gerente;
import backend.service.equipos.Equipo;
import backend.service.equipos.EquipoEnFormacion;
import backend.service.equipos.EquipoProfesional;
import backend.service.eventos.Partido;
import backend.service.horarios.FranjaTiempo;
import shared.gestionempleados.PuestoEmpleado;
import shared.gestionequipos.GestorEquipos;
import util.DateToLocalTimeConverter;

public class GestionPartidosShared {
	
	EquipoCRUDService serviceEquip = CreadorDataService.getEquiposService();
	private GestorEquipos gestorEquipos = new Gerente();
	EntrevistaCRUDService serviceEntrevista = new EntrevistaCRUDImpl();
	PartidosCRUDService servicePartidos = new PartidosCRUDImpl();
	EmpleadosCRUDService serviceEmp = CreadorDataService.getEmpleadosService();
	
	public GestionPartidosShared() {
		cargarEquipos();
		cargarEmpleadosDeportivos();
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
	
	public List<Equipo> getEquipo() {
		return gestorEquipos.getEquipos();
	}
	
	public Equipo buscaEquipo(String idEquipo) {
		return gestorEquipos.getEquipoByID(idEquipo);
	}
	
	public void addPartido(Equipo equipo, String visitante, Date fecha, FranjaTiempo franja, boolean isEspecial) {
		String idPartido = UUID.randomUUID().toString();
		Partido partido = new Partido(fecha, franja, visitante, isEspecial, idPartido, equipo.getIdEquipo());
		
		//Añado el partido a la lista de partidos del equipo
		equipo.getPartidos().add(partido);
		
		//Añado el partido a la BDD
		addPartidoABBDD(partido);
		
		//Borro si existe alguna entrevista o franja que coincida con el entrenamiento
		borraEntrevistaYFranjaDeBBDD(franja, equipo);
	}
	
	private void addPartidoABBDD(Partido partido) {
		PartidoDTO dto = new PartidoDTO();
		dto.fecha = partido.getFecha();
		dto.horaFin = DateToLocalTimeConverter.combinarFechaYHora(partido.getFecha(), partido.getHorario().getHoraFin());
		dto.horaInicio = DateToLocalTimeConverter.combinarFechaYHora(partido.getFecha(), partido.getHorario().getHoraInicio());
		dto.id = partido.getIdPartido();
		dto.idEquipo = partido.getIdEquipoLocal();
		dto.tieneSuplemento = partido.isEspecial();
		dto.visitante = partido.getVisitante();
		
		servicePartidos.addPartido(dto);
	}

	private void borraEntrevistaYFranjaDeBBDD(FranjaTiempo horario, Equipo equipo) {
		for(Jugador jugador : equipo.getJugadores()) {
			serviceEntrevista.deleteEntrevistaYFranjaPorHora(horario, jugador.getIDEmpleado());
		}
	}

	

}
