package shared.gestioncampania;

import java.util.Optional;

import backend.data.CreadorDataService;
import backend.data.campaniaaccionistas.CampaniaAccionistasCRUDService;
import backend.data.campaniaaccionistas.CampaniaDTO;
import backend.data.campaniaaccionistas.DtoAssembler;
import backend.service.ventas.campanaAccionistas.CampaniaAccionistas;

public class GestionCampaniaShared {

	private GestorCampania gestor = new GestorDeCampanias();
	private CampaniaAccionistasCRUDService service = CreadorDataService.getCampaniasService();
	
	
	public GestionCampaniaShared() {
		
	}

	public void crearCampania(int numAcciones) {
		// Crear el objeto campaña
		
		// Guardar los datos de la campaña en la BBDD
		
	}

	/**
	 * Carga la campania que se estaba llevando a cabo durante la última ejecución de la aplicación si es que
	 * la hay
	 * 
	 * @return true si existia una campaña en curso, false en caso contrario
	 */
	public boolean cargarCampaniaEnCurso() {
		Optional<CampaniaDTO> optDTO = service.findEnCurso();
		if (optDTO.isEmpty())
			return false;
		CampaniaDTO dto = optDTO.get();
		CampaniaAccionistas campania = DtoAssembler.dtoToCampania(dto);
		gestor.cargarCampania(campania);
		return true;
	}
	
	
}
