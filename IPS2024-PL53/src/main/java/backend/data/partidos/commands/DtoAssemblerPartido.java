package backend.data.partidos.commands;

import java.util.ArrayList;
import java.util.List;

import backend.data.partidos.PartidoDTO;
import backend.service.eventos.Partido;
import backend.service.horarios.FranjaTiempo;
import backend.service.horarios.TipoEvento;
import util.DateToLocalDate;
import util.DateToLocalTimeConverter;

public class DtoAssemblerPartido {

	public static List<Partido> dtoToPartido(List<PartidoDTO> listDto){
		List<Partido> listaIns = new ArrayList<Partido>();
		for (PartidoDTO dto : listDto) {
			FranjaTiempo franja = new FranjaTiempo(TipoEvento.PARTIDO, DateToLocalTimeConverter.convertDateToLocalTime(dto.horaInicio),
					DateToLocalTimeConverter.convertDateToLocalTime(dto.horaFin), DateToLocalDate.convertToLocalDate(dto.fecha));
			Partido par = new Partido(dto.fecha, franja, dto.visitante, dto.tieneSuplemento, dto.id, dto.idEquipo);
			
			listaIns.add(par);
		}
		return listaIns;
	}
}
