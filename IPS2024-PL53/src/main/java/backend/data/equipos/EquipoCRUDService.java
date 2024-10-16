package backend.data.equipos;

import java.util.List;

public interface EquipoCRUDService {
	
	List<EquipoProfesionalDto> cargarEquipoProfesional();
	
	List<EquipoEnFormacionDto> cargarEquipoEnFormacion();
	
	void addEquipoProfesional(EquipoProfesionalDto dto);
	
	void addEquipoEnFormacion(EquipoEnFormacionDto dto);
}
