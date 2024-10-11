package backend.data.entrenamientos.commands;

import java.util.ArrayList;
import java.util.List;

import backend.data.entrenamientos.EntrenamientoDto;
import backend.service.eventos.Entrenamiento;
import backend.service.horarios.FranjaTiempo;
import backend.service.horarios.TipoEvento;
import backend.service.ventas.reservas.Instalacion;
import shared.gestioninstalaciones.ReservaShared;
import util.DateToLocalDate;
import util.DateToLocalTimeConverter;

public class DtoAssemblerEntrenamientos {
	
	public DtoAssemblerEntrenamientos(ReservaShared res) {
		this.res = res;
	}
	
	private ReservaShared res;
	
	public List<Entrenamiento> dtoToEntrenamiento(List<EntrenamientoDto> listDto){
		List<Entrenamiento> listaIns = new ArrayList<Entrenamiento>();
		for (EntrenamientoDto dto : listDto) {
			Instalacion inst = res.buscaInstalacion(dto.codInstalacion);
			FranjaTiempo franja = new FranjaTiempo(TipoEvento.ENTRENAMIENTO, DateToLocalTimeConverter.convertDateToLocalTime(dto.horaInicio),
					DateToLocalTimeConverter.convertDateToLocalTime(dto.horaFinal), DateToLocalDate.convertToLocalDate(dto.fecha) );
			Entrenamiento ent = new Entrenamiento(dto.fecha, franja, inst);
			
			listaIns.add(ent);
		}
		return listaIns;
	}

}
