package shared.gestionequipos.partidos;

import java.util.Date;
import java.util.List;

import backend.data.CreadorDataService;
import backend.data.entrevistas.EntrevistaCRUDImpl;
import backend.data.entrevistas.EntrevistaCRUDService;
import backend.data.equipos.EquipoCRUDService;
import backend.data.equipos.command.DtoAssemblerEquipo;
import backend.service.empleados.nodeportivos.Gerente;
import backend.service.equipos.Equipo;
import backend.service.equipos.EquipoEnFormacion;
import backend.service.equipos.EquipoProfesional;
import backend.service.horarios.FranjaTiempo;
import shared.gestionequipos.GestorEquipos;

public class GestionPartidosShared {
	
	EquipoCRUDService serviceEquip = CreadorDataService.getEquiposService();
	private GestorEquipos gestorEquipos = new Gerente();
	EntrevistaCRUDService serviceEntrevista = new EntrevistaCRUDImpl();
	
	public GestionPartidosShared() {
		cargarEquipos();
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
	
	public List<Equipo> getEquipo() {
		return gestorEquipos.getEquipos();
	}
	
	
	public void addPartido(Equipo equipo, String visitante, Date fecha, FranjaTiempo franja, boolean isEspecial) {
		
	}

	public Equipo buscaEquipo(String idEquipo) {
		return gestorEquipos.getEquipoByID(idEquipo);
	}

}
