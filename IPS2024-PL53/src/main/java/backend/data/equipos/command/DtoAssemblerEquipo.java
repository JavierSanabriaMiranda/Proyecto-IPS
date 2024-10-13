package backend.data.equipos.command;

import java.util.ArrayList;
import java.util.List;

import backend.data.equipos.EntrenadorDto;
import backend.data.equipos.EquipoEnFormacionDto;
import backend.data.equipos.EquipoProfesionalDto;
import backend.data.equipos.JugadorDto;
import backend.service.empleados.deportivos.Entrenador;
import backend.service.empleados.deportivos.Jugador;
import backend.service.equipos.CategoriaEquipoFormacion;
import backend.service.equipos.EquipoEnFormacion;
import backend.service.equipos.EquipoProfesional;
import backend.service.equipos.NivelEquipoProfesional;

public class DtoAssemblerEquipo {

	public static List<Jugador> dtoToJugador(List<JugadorDto> listDto){
		List<Jugador> lista = new ArrayList<Jugador>();
		for (JugadorDto dto : listDto) {
			Jugador jugador = new Jugador(dto.nombre, dto.apellido, dto.DNI, dto.telefono, dto.fechaNac, dto.salario);
			lista.add(jugador);
		}
		return lista;
	}
	
	public static List<Entrenador> dtoToEntrenador(List<EntrenadorDto> listDto){
		List<Entrenador> lista = new ArrayList<Entrenador>();
		for (EntrenadorDto dto : listDto) {
			Entrenador entrenador = new Entrenador(dto.nombre, dto.apellido, dto.DNI, dto.telefono, dto.fechaNac, dto.salario);
			lista.add(entrenador);
		}
		return lista;
	}
	
	
	public static List<EquipoProfesional> dtoToEquipoProfesional(List<EquipoProfesionalDto> listDto){
		List<EquipoProfesional> lista = new ArrayList<EquipoProfesional>();
		for (EquipoProfesionalDto dto : listDto) {
			NivelEquipoProfesional nivel;
			if (dto.equipoProfesionalDelQueEsFilial == null)
				nivel = NivelEquipoProfesional.PRIMER_EQUIPO;
			else
				nivel = NivelEquipoProfesional.FILIAL;
			EquipoProfesional equipo = new EquipoProfesional(nivel, dto.idEquipo);
			lista.add(equipo);
		}
		return lista;
	}
	
	public static List<EquipoEnFormacion> dtoToEquipoEnFormacion(List<EquipoEnFormacionDto> listDto){
		List<EquipoEnFormacion> lista = new ArrayList<EquipoEnFormacion>();
		for (EquipoEnFormacionDto dto : listDto) {
			CategoriaEquipoFormacion categoria = CategoriaEquipoFormacion.valueOf(dto.categoria.toUpperCase());
			EquipoEnFormacion equipo = new EquipoEnFormacion(categoria, dto.idEquipo);
			lista.add(equipo);
		}
		return lista;
	}
	
	
}
