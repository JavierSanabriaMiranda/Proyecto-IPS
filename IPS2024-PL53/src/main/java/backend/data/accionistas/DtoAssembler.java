package backend.data.accionistas;

import backend.service.ventas.campanaAccionistas.Accionista;

public class DtoAssembler {

	public static Accionista dtoToAccionista(AccionistaDTO dto) {
		String id = dto.idAccionista;
		String dni = dto.dniAccionista;
		String nombre = dto.nombreAccionista;
		
		return new Accionista(id, dni, nombre);
	}

	public static AccionistaDTO toDto(Accionista accionista) {
		AccionistaDTO dto = new AccionistaDTO();
		dto.idAccionista = accionista.getIdAccionista();
		dto.dniAccionista = accionista.getDni(); 
		dto.nombreAccionista = accionista.getNombre();
		return dto;
	}
} 
