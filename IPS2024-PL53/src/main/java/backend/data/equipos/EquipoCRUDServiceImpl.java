package backend.data.equipos;

import java.util.List;

import backend.data.equipos.command.AddEquipoEnFormacion;
import backend.data.equipos.command.AddEquipoProfesional;
import backend.data.equipos.command.CargarEquiposEnFormacion;
import backend.data.equipos.command.CargarEquiposProfesionales;

public class EquipoCRUDServiceImpl implements EquipoCRUDService {


	@Override
	public List<EquipoProfesionalDto> cargarEquipoProfesional() {
		return new CargarEquiposProfesionales().execute();
	}

	@Override
	public List<EquipoEnFormacionDto> cargarEquipoEnFormacion() {
		return new CargarEquiposEnFormacion().execute();
	}

	@Override
	public void addEquipoProfesional(EquipoProfesionalDto dto) {
		new AddEquipoProfesional(dto).execute();
	}

	@Override
	public void addEquipoEnFormacion(EquipoEnFormacionDto dto) {
		new AddEquipoEnFormacion(dto).execute();
	}
	
	

}
