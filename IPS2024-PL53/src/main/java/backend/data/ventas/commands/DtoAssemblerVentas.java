package backend.data.ventas.commands;

import java.util.ArrayList;
import java.util.List;

import backend.data.ventas.ReservaDto;
import backend.service.horarios.FranjaTiempo;
import backend.service.horarios.TipoEvento;
import backend.service.ventas.reservas.ClienteReserva;
import backend.service.ventas.reservas.Instalacion;
import backend.service.ventas.reservas.Reserva;
import shared.gestioninstalaciones.GestorReserva;
import util.DateToLocalDate;
import util.DateToLocalTimeConverter;

public class DtoAssemblerVentas {
	
	public DtoAssemblerVentas(GestorReserva gestor) {
		this.ges = gestor;
	}
	
	private GestorReserva ges;

	public  List<Reserva> dtoToReserva(List<ReservaDto> listDto){
		List<Reserva> listaIns = new ArrayList<Reserva>();
		for (ReservaDto dto : listDto) {
			Instalacion inst = ges.buscaInstalacion(dto.codInstalacion);
			ClienteReserva cliente =  new ClienteReserva(dto.nombreCliente);
			FranjaTiempo franja = new FranjaTiempo(TipoEvento.RESERVA, DateToLocalTimeConverter.convertDateToLocalTime(dto.horaInicio),
					DateToLocalTimeConverter.convertDateToLocalTime(dto.horaFin), DateToLocalDate.convertToLocalDate(dto.fecha));
			Reserva ent = new Reserva(dto.codReserva,  franja, inst, cliente, dto.coste, dto.fecha, dto.numTarjeta);
			
			listaIns.add(ent);
		}
		return listaIns;
	}
}
