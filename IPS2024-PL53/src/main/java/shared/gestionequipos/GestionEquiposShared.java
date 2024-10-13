package shared.gestionequipos;

import java.util.ArrayList;
import java.util.List;

import backend.data.CreadorDataService;
import backend.data.empleados.DtoAssembler;
import backend.data.empleados.EmpleadoDeportivoDTO;
import backend.data.empleados.EmpleadosCRUDService;
import backend.data.equipos.EquipoCRUDService;
import backend.data.equipos.EquipoEnFormacionDto;
import backend.data.equipos.EquipoProfesionalDto;
import backend.data.equipos.command.DtoAssemblerEquipo;
import backend.service.empleados.EmpleadoDeportivo;
import backend.service.empleados.nodeportivos.Gerente;
import backend.service.equipos.CategoriaEquipoFormacion;
import backend.service.equipos.Equipo;
import backend.service.equipos.EquipoEnFormacion;
import backend.service.equipos.EquipoProfesional;
import backend.service.equipos.NivelEquipoProfesional;
import shared.gestionempleados.PuestoEmpleado;

public class GestionEquiposShared {

	EmpleadosCRUDService serviceEmp = CreadorDataService.getEmpleadosService();
	EquipoCRUDService serviceEquip = CreadorDataService.getEquiposService();
	private GestorEquipos gestor = new Gerente();

	public GestionEquiposShared() {
		cargarEquipos();
		cargarEmpleadosDeportivos();
	}

	private void cargarEquipos() {
		// Cargo los equipos profesionales
		List<EquipoProfesional> equiposPros = DtoAssemblerEquipo
				.dtoToEquipoProfesional(serviceEquip.cargarEquipoProfesional());
		for (EquipoProfesional equipo : equiposPros) {
			gestor.addEquipo(equipo);
		}
		// Cargo los equipos en formacion
		List<EquipoEnFormacion> equiposFor = DtoAssemblerEquipo
				.dtoToEquipoEnFormacion(serviceEquip.cargarEquipoEnFormacion());
		for (EquipoEnFormacion equipo : equiposFor) {
			gestor.addEquipo(equipo);
		}
	}

	private void cargarEmpleadosDeportivos() {
		List<EmpleadoDeportivo> lista = new ArrayList<EmpleadoDeportivo>();
		List<EmpleadoDeportivoDTO> empDeportivosDtos = serviceEmp.cargarEmpleadosDeportivos();
		for (EmpleadoDeportivoDTO dto : empDeportivosDtos) {
			Equipo equipo = gestor.getEquipoByID(dto.id_equipo);
			EmpleadoDeportivo emp = DtoAssembler.dtoToEmpleadoDeportivo(dto);
			emp.setEquipo(equipo);
			lista.add(emp);
		}

		cargarEmpleadosDeportivosEnGestor(lista);
	}

	private void cargarEmpleadosDeportivosEnGestor(List<EmpleadoDeportivo> empleadosDeportivos) {
		for (EmpleadoDeportivo emp : empleadosDeportivos) {
			gestor.addEmpleadoDeportivo(emp);
		}
	}

	public List<EmpleadoDeportivo> getJugadoresSinEquipo() {
		return gestor.getJugadoresSinEquipo();
	}

	public List<EmpleadoDeportivo> getEntrenadoresSinEquipo() {
		return gestor.getEntrenadoresSinEquipo();
	}
	
	public List<Equipo> getEquiposProfesionales(){
		return gestor.getEquiposPimerosEquipos();
	}
	
	
	public void añadeEquipoProfesional(List<EmpleadoDeportivo> jugadoresEquipo, List<EmpleadoDeportivo> entrenadoresEquipo, NivelEquipoProfesional nivel, String filialDe) {
		String idEquipo = gestor.generarIDEquipo();
		addEquipoProfesionalABBDD(filialDe, idEquipo);
		updateEmpleadosEnBBDD(jugadoresEquipo, entrenadoresEquipo, idEquipo);
		updateEquipoProfesionalEnEmpleadosYGestor(jugadoresEquipo, entrenadoresEquipo, nivel, idEquipo);
	}

	private void updateEquipoProfesionalEnEmpleadosYGestor(List<EmpleadoDeportivo> jugadoresEquipo,
			List<EmpleadoDeportivo> entrenadoresEquipo, NivelEquipoProfesional nivel, String idEquipo) {
		//Añadir al gerente el nuevo Equipo
		Equipo equipo = new EquipoProfesional(nivel, idEquipo);
		gestor.addEquipo(equipo);
		//Añadir el equipo a los Empleados
		for (EmpleadoDeportivo jugador : jugadoresEquipo) {
			jugador.setEquipo(equipo);
		}
		for (EmpleadoDeportivo entrenador: entrenadoresEquipo) {
			entrenador.setEquipo(equipo);
		}
	}

	private void updateEmpleadosEnBBDD(List<EmpleadoDeportivo> jugadoresEquipo,
			List<EmpleadoDeportivo> entrenadoresEquipo, String idEquipo) {
		//Actualizar los jugadores y entrenadores al nuevo idEquipo en la Base de Datos
		for (EmpleadoDeportivo jugador : jugadoresEquipo) {
			EmpleadoDeportivoDTO dtoJug = new EmpleadoDeportivoDTO();
			dtoJug.id_equipo = idEquipo;
			dtoJug.id = jugador.getIDEmpleado();
			dtoJug.posicion = PuestoEmpleado.JUGADOR.toString();
			serviceEmp.updateEmpleadoDeportivo(dtoJug);
		}
		int numeroEntrenador = 0;
		for (EmpleadoDeportivo entrenador: entrenadoresEquipo) {
			numeroEntrenador++;
			EmpleadoDeportivoDTO dtoEmp = new EmpleadoDeportivoDTO();
			dtoEmp.id_equipo = idEquipo;
			dtoEmp.id = entrenador.getIDEmpleado();
			dtoEmp.posicion = PuestoEmpleado.ENTRENADOR.toString();
			dtoEmp.numeroEntrenador = numeroEntrenador;
			serviceEmp.updateEmpleadoDeportivo(dtoEmp);
		}
	}

	private void addEquipoProfesionalABBDD(String filialDe, String idEquipo) {
		//Añadir un nuevo equipo profesional a la Base de Datos
		EquipoProfesionalDto dto = new EquipoProfesionalDto();
		dto.idEquipo = idEquipo;
		dto.equipoProfesionalDelQueEsFilial = filialDe;
		serviceEquip.addEquipoProfesional(dto);
	}

	
	public void añadeEquipoEnFormacion(List<EmpleadoDeportivo> jugadoresEquipo, List<EmpleadoDeportivo> entrenadoresEquipo, String categoria) {
		String idEquipo = gestor.generarIDEquipo();
		addEquipoFormacionABBDD(idEquipo, categoria);
		updateEmpleadosEnBBDD(jugadoresEquipo, entrenadoresEquipo, idEquipo);
		updateEquipoFormacionEnEmpleadosYGestor(jugadoresEquipo, entrenadoresEquipo, categoria, idEquipo);
		
	}
	
	private void addEquipoFormacionABBDD(String idEquipo, String categoria) {
		//Añadir un nuevo equipo profesional a la Base de Datos
		EquipoEnFormacionDto dto = new EquipoEnFormacionDto();
		dto.idEquipo = idEquipo;
		dto.categoria = categoria;
		serviceEquip.addEquipoEnFormacion(dto);
	}
	
	private void updateEquipoFormacionEnEmpleadosYGestor(List<EmpleadoDeportivo> jugadoresEquipo,
			List<EmpleadoDeportivo> entrenadoresEquipo, String categoria, String idEquipo) {
		//Añadir al gerente el nuevo Equipo
		CategoriaEquipoFormacion cate = CategoriaEquipoFormacion.getCategoria(categoria);
		Equipo equipo = new EquipoEnFormacion(cate, idEquipo);
		gestor.addEquipo(equipo);
		//Añadir el equipo a los Empleados
		for (EmpleadoDeportivo jugador : jugadoresEquipo) {
			jugador.setEquipo(equipo);
		}
		for (EmpleadoDeportivo entrenador: entrenadoresEquipo) {
			entrenador.setEquipo(equipo);
		}
	}

}
