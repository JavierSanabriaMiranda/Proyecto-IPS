package backend.data.equipos;

import java.util.List;

import backend.data.equipos.command.AddEquipoEnFormacion;
import backend.data.equipos.command.AddEquipoProfesional;
import backend.data.equipos.command.CargarEquiposEnFormacion;
import backend.data.equipos.command.CargarEquiposProfesionales;
import backend.util.log.LogManager;

public class EquipoCRUDServiceImpl implements EquipoCRUDService {


	@Override
	public List<EquipoProfesionalDto> cargarEquipoProfesional() {
		LogManager.logAction("Acceso a Base de Datos. Tabla: EQUIPO_PROFESIONAL");
		return new CargarEquiposProfesionales().execute();
	}

	@Override
	public List<EquipoEnFormacionDto> cargarEquipoEnFormacion() {
		LogManager.logAction("Acceso a Base de Datos. Tabla: EQUIPO_FORMACION");
		return new CargarEquiposEnFormacion().execute();
	}

	@Override
	public void addEquipoProfesional(EquipoProfesionalDto dto) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: EQUIPO_PROFESIONAL");
		new AddEquipoProfesional(dto).execute();
	}

	@Override
	public void addEquipoEnFormacion(EquipoEnFormacionDto dto) {
		LogManager.logAction("Modificación en Base de Datos. Tabla: EQUIPO_FORMACION");
		new AddEquipoEnFormacion(dto).execute();
	}
	
	

}
