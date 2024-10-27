package backend.data.campaniaaccionistas;

import backend.service.ventas.campanaAccionistas.CampaniaAccionistas;
import backend.service.ventas.campanaAccionistas.CampaniaAccionistas.EstadoCampania;

public class DtoAssembler {

	public static CampaniaAccionistas dtoToCampania(CampaniaDTO dto) {
		String cod = dto.codCampania;
		int accIni = dto.accionesIniciales;
		int accRest = dto.accionesRestantes;
		int fase = dto.fase;
		EstadoCampania estado;
		if (dto.estado.equalsIgnoreCase("ABIERTA"))
			estado = EstadoCampania.ABIERTA;
		else
			estado = EstadoCampania.FINALIZADA;
		
		
		return new CampaniaAccionistas(cod, accIni, accRest, fase, estado);
	}
	
	public static CampaniaDTO toDto(CampaniaAccionistas c) {
		CampaniaDTO dto = new CampaniaDTO();
		dto.codCampania = c.getCodigoCampania();
		dto.accionesIniciales = c.getNumAccionesIniciales();
		dto.accionesRestantes = c.getNumAccionesRestantes();
		dto.estado = c.getEstado().toString();
		dto.fase = c.getFase();
		return dto;
	}
}
