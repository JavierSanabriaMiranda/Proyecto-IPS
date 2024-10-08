package backend.data.instalaciones.commands;

import java.util.ArrayList;
import java.util.List;

import backend.data.instalaciones.InstalacionDto;
import backend.service.ventas.reservas.Instalacion;

public class DtoAssembler {

	public static List<Instalacion> dtoToInstalacion(List<InstalacionDto> listDto){
		List<Instalacion> listaIns = new ArrayList<Instalacion>();
		for (InstalacionDto dto : listDto) {
			Instalacion ins = new Instalacion(dto.codInstalacion);
			listaIns.add(ins);
		}
		return listaIns;
	}
}
