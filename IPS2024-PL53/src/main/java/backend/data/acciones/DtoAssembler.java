package backend.data.acciones;

import java.util.ArrayList;
import java.util.List;

import backend.service.ventas.campanaAccionistas.Accion;

public class DtoAssembler {

	public static List<AccionDTO> toDtoList(List<Accion> acciones, String idAccionista) {
		List<AccionDTO> list = new ArrayList<>();
		for (Accion acc : acciones)
			list.add(toDto(acc, idAccionista));
		
		return list;
	}
	
	public static AccionDTO toDto(Accion acc, String idAccionista) {
		
		AccionDTO dto = new AccionDTO();
		dto.setIdAccion(acc.getIdAccion());
		dto.setPrecio(acc.getPrecio());
		dto.setIdAccionista(idAccionista);
		
		return dto;
	}
	
	public static List<Accion> toAccionList(List<AccionDTO> dtos) {
		List<Accion> list = new ArrayList<Accion>();
		for (AccionDTO dto : dtos)  
			list.add(toAccion(dto));
		return list;
	}
	
	public static Accion toAccion(AccionDTO dto) {
		String idAccion = dto.getIdAccion();
		String idAccionista = dto.getIdAccionista();
		float precio = dto.getPrecio();
		boolean isEnVenta = dto.isEnVenta();
		
		return new Accion(idAccion, precio, isEnVenta);
	}
}
